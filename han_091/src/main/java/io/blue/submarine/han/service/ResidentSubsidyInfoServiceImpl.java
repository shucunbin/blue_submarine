package io.blue.submarine.han.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import io.blue.submarine.han.core.model.resident.*;
import io.blue.submarine.han.rpc.LszRpcService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 居民补助服务接口实现类.
 *
 * @author shucunbin
 * @date 2022-02-07 10:23
 */
@Service
@Slf4j
public class ResidentSubsidyInfoServiceImpl implements ResidentSubsidyInfoService {

    @Autowired
    private ResidentSubsidyInfoIndexService residentSubsidyInfoIndexService;

    @Autowired
    private ResidentInfoService residentInfoService;

    @Autowired
    private LszRpcService lszRpcService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public void initData() {
        residentSubsidyInfoIndexService.createResidentSubsidyInfoIndexIfNotExist();
        List<ResidentInfo> residentInfoList = residentInfoService.readFromExcel();
        List<String> noSubsidyInfoList = Lists.newArrayList();
        for (ResidentInfo residentInfo : residentInfoList) {
            String residentId = residentInfo.getResidentId();
            if ("残疾".equalsIgnoreCase(residentInfo.getHealthStatus())) {
                residentId = residentId.substring(0, residentId.length() - 2);
            }
            String reqParam = objectMapper.writeValueAsString(new ResidentSubsidyInfoRequest(residentId));
            String response = lszRpcService.getResidentSubsidyInfo(reqParam);

            ResidentSubsidyInfoResponse residentSubsidyInfoResponse = null;
            try {
                residentSubsidyInfoResponse = objectMapper.readValue(response, ResidentSubsidyInfoResponse.class);
            } catch (Exception ignored) {
                noSubsidyInfoList.add(residentId);
            }

            if (Objects.nonNull(residentSubsidyInfoResponse)) {
                List<ResidentSubsidyInfo> residentSubsidyInfoList = residentSubsidyInfoResponse.convertToResidentSubsidyInfoList();
                for (ResidentSubsidyInfo residentSubsidyInfo : residentSubsidyInfoList) {
                    residentSubsidyInfo.setHouseholdId(residentInfo.getHouseholdId());
                    residentSubsidyInfo.setHouseholdRole(residentInfo.getHouseholdRole());
                    residentSubsidyInfo.setResidentId(residentId);
                    residentSubsidyInfo.setSubsidyType(SubsidyItemEnum.getTypeByName(residentSubsidyInfo.getSubsidyItem()));
                }

                residentSubsidyInfoIndexService.batchIndexResidentSubsidyInfo(residentSubsidyInfoList);
            }

            log.info(">>>>>> the total number of the resident id is : {}", residentInfoList.size());
            log.info(">>>>>> the number of the resident id of no subsidy info is : {}", noSubsidyInfoList.size());
            log.info(">>>>>> the resident id list of no subsidy info : {}", noSubsidyInfoList);
        }
    }

    @Override
    @SneakyThrows
    public void exportExcel() {
        Map<String, String> householdId2HouseholdHeaderNameMap = Maps.newHashMap();
        List<ResidentInfo> residentInfoList = residentInfoService.readFromExcel();
        for (ResidentInfo residentInfo : residentInfoList)  {
            if ("户主".equalsIgnoreCase(residentInfo.getHouseholdRole())) {
                householdId2HouseholdHeaderNameMap.put(residentInfo.getHouseholdId(), residentInfo.getResidentName());
            }
        }


        List<ResidentSubsidyInfo> residentSubsidyInfoListFromEs = residentSubsidyInfoIndexService.searchResidentSubsidyInfo("202010",
                "202109");
        String excelFileName = this.getClass().getResource("/doc/").getPath() +System.currentTimeMillis() + "_补贴信息" + ".xlsx";
        ExcelWriter excelWriter = EasyExcel.write(excelFileName).build();
        // 按户分组
        Map<String,List<ResidentSubsidyInfo>>groupByHouseholdIdMap = residentSubsidyInfoListFromEs.stream()
                .collect(Collectors.groupingBy(ResidentSubsidyInfo::getHouseholdId));
        for (Map.Entry<String, List<ResidentSubsidyInfo>> entry : groupByHouseholdIdMap.entrySet()) {
            List<ResidentSubsidyInfo> residentSubsidyInfoList = entry.getValue();
            Optional<ResidentSubsidyInfo> householdHeaderOptional = residentSubsidyInfoList.stream()
                    .filter(residentSubsidyInfo -> "户主".equalsIgnoreCase(residentSubsidyInfo.getHouseholdRole()))
                    .findFirst();
            String householdHeaderName = "";
            if (householdHeaderOptional.isPresent()) {
                householdHeaderName = householdHeaderOptional.get().getResidentName();
            }
            if (StringUtils.isBlank(householdHeaderName)) {
                log.info(">>>>>> {} - 户主为空......", entry.getKey());
                householdHeaderName = householdId2HouseholdHeaderNameMap.getOrDefault(entry.getKey(),entry.getKey());
                log.info(">>>>>> 户主更新为:{}......", householdHeaderName);
            }

            List<ResidentSubsidyInfoExcel> residentSubsidyInfoExcelList = Lists.newArrayList();
            List<ResidentSubsidyInfoExcel2> residentSubsidyInfoExcel2List = Lists.newArrayList();
            // 按补贴类型分组
            Map<String, List<ResidentSubsidyInfo>> groupBySubsidyTypeMap = residentSubsidyInfoList.stream()
                    .collect(Collectors.groupingBy(ResidentSubsidyInfo::getSubsidyType));
            for (Map.Entry<String, List<ResidentSubsidyInfo>> groupBySubsidyTypeEntry : groupBySubsidyTypeMap.entrySet()) {
                ResidentSubsidyInfoExcel residentSubsidyInfoExcel = buildResidentSubsidyInfoExcel(
                        groupBySubsidyTypeEntry.getKey(),groupBySubsidyTypeEntry.getValue());
                residentSubsidyInfoExcel.setResidentName(householdHeaderName);
                residentSubsidyInfoExcelList.add(residentSubsidyInfoExcel);

                residentSubsidyInfoExcel2List.addAll(buildResidentSubsidyInfoExcel2(householdHeaderName,
                        groupBySubsidyTypeEntry.getKey(),groupBySubsidyTypeEntry.getValue()));
            }

            // 每个用户两个 sheet
            WriteSheet writeSheet1 = EasyExcel.writerSheet(householdHeaderName + "_1")
                    .head(ResidentSubsidyInfoExcel.class)
                    .build();
            excelWriter.write(residentSubsidyInfoExcelList, writeSheet1);

            WriteSheet writeSheet2 = EasyExcel.writerSheet(householdHeaderName + "_2")
                    .head(ResidentSubsidyInfoExcel2.class)
                    .build();
            excelWriter.write(residentSubsidyInfoExcel2List, writeSheet2);

        }

        // 关闭
        excelWriter.finish();
    }

    private ResidentSubsidyInfoExcel buildResidentSubsidyInfoExcel(String subsidyType, List<ResidentSubsidyInfo> residentSubsidyInfoList) {
        BigDecimal totalAmount = new BigDecimal("0");
        Map<String, BigDecimal> month2Amount = Maps.newHashMap();
        for (ResidentSubsidyInfo residentSubsidyInfo : residentSubsidyInfoList) {
            String yearMonth = residentSubsidyInfo.getSubsidiesDate();
            if (month2Amount.containsKey(yearMonth)) {
                month2Amount.put(yearMonth, month2Amount.get(yearMonth).add(residentSubsidyInfo.getSubsidyAmount()));
            } else {
                month2Amount.put(yearMonth, residentSubsidyInfo.getSubsidyAmount());
            }
            totalAmount = totalAmount.add(residentSubsidyInfo.getSubsidyAmount());
        }

        ResidentSubsidyInfoExcel residentSubsidyInfoExcel = new ResidentSubsidyInfoExcel();
        residentSubsidyInfoExcel.setSubsidyType(subsidyType);
        residentSubsidyInfoExcel.setYm1(month2Amount.getOrDefault("202010", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm2(month2Amount.getOrDefault("202011", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm3(month2Amount.getOrDefault("202012", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm4(month2Amount.getOrDefault("202101", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm5(month2Amount.getOrDefault("202102", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm6(month2Amount.getOrDefault("202103", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm7(month2Amount.getOrDefault("202104", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm8(month2Amount.getOrDefault("202105", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm9(month2Amount.getOrDefault("202106", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm10(month2Amount.getOrDefault("202107", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm11(month2Amount.getOrDefault("202108", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setYm12(month2Amount.getOrDefault("202109", new BigDecimal("0.00")).toPlainString());
        residentSubsidyInfoExcel.setSubsidyTotalAmount(totalAmount.toPlainString());

        return residentSubsidyInfoExcel;
    }

    private List<ResidentSubsidyInfoExcel2>  buildResidentSubsidyInfoExcel2(String residentName, String subsidyType,
                                                                            List<ResidentSubsidyInfo> residentSubsidyInfoList) {
        Map<String, BigDecimal> subsidyItem2TotalAmountMap = Maps.newHashMap();
        for (ResidentSubsidyInfo residentSubsidyInfo : residentSubsidyInfoList) {
            if (subsidyItem2TotalAmountMap.containsKey(residentSubsidyInfo.getSubsidyItem())) {
                subsidyItem2TotalAmountMap.put(residentSubsidyInfo.getSubsidyItem(),
                        subsidyItem2TotalAmountMap.get(residentSubsidyInfo.getSubsidyItem()).add(residentSubsidyInfo.getSubsidyAmount()));
            } else {
                subsidyItem2TotalAmountMap.put(residentSubsidyInfo.getSubsidyItem(), residentSubsidyInfo.getSubsidyAmount());
            }
        }

        List<ResidentSubsidyInfoExcel2> residentSubsidyInfoExcel2List = Lists.newArrayList();
        for (String subsidyItem : subsidyItem2TotalAmountMap.keySet()) {
            ResidentSubsidyInfoExcel2 residentSubsidyInfoExcel2 = new ResidentSubsidyInfoExcel2();
            residentSubsidyInfoExcel2.setResidentName(residentName);
            residentSubsidyInfoExcel2.setSubsidyType(subsidyType);
            residentSubsidyInfoExcel2.setSubsidyItem(subsidyItem);
            residentSubsidyInfoExcel2.setSubsidyItemTotalAmount(subsidyItem2TotalAmountMap.getOrDefault(subsidyItem,
                    new BigDecimal("0.00")).toPlainString());
            residentSubsidyInfoExcel2List.add(residentSubsidyInfoExcel2);
        }

        return residentSubsidyInfoExcel2List;
    }
}
