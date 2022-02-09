package io.blue.submarine.han.core.model.resident;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 居民养老保险信息请求响应类.
 * @author shucunbin
 * @date 2022-02-07 20:50
 */
@Getter
@Setter
@ToString
public class ResidentSubsidyInfoResponse2 {
    private String code;
    private String message;
    private Output output;

    public List<ResidentSubsidyInfo> convertToResidentSubsidyInfoList() {
        List<ResidentSubsidyInfo> residentSubsidyInfoList = null;
        if ("NOERROR".equalsIgnoreCase(code) && Objects.nonNull(output) && CollectionUtils.isNotEmpty(
                output.getResultset())) {
            residentSubsidyInfoList = output.getResultset().stream()
                    .map(resultSet -> {
                        ResidentSubsidyInfo residentSubsidyInfo = new ResidentSubsidyInfo();
                        residentSubsidyInfo.setResidentName(resultSet.getResidentName());
                        residentSubsidyInfo.setSubsidyItem(resultSet.getSubsidyItem());
                        residentSubsidyInfo.setSubsidyBatchNo(resultSet.getBatchNo());
                        residentSubsidyInfo.setSubsidyAmount(resultSet.getSubsidyAmount());
                        residentSubsidyInfo.setBankName(resultSet.getBankName());
                        residentSubsidyInfo.setBankAccountName(resultSet.getBankAccountName());
                        residentSubsidyInfo.setBankAccount(resultSet.getBankAccount());
                        residentSubsidyInfo.setSubsidiesDate(resultSet.getSubsidiesDate());
                        residentSubsidyInfo.setSubsidiesStatus(0);
                        residentSubsidyInfo.setCreateTime(System.currentTimeMillis());
                        residentSubsidyInfo.setUpdateTime(System.currentTimeMillis());
                        return residentSubsidyInfo;
                    }).collect(Collectors.toList());
        }

        if (residentSubsidyInfoList == null) {
            residentSubsidyInfoList = Collections.emptyList();
        }

        return residentSubsidyInfoList;
    }

    @Getter
    @Setter
    static class Output {
        List<ResidentSubsidyInfoResponse2.ResultSet> resultset;
    }

    @Getter
    @Setter
    static class ResultSet {
        @JsonProperty("aae002")
        private String subsidiesDate;

        @JsonProperty("aae133")
        private String residentName;

        @JsonProperty("aae136")
        private String residentId;

        private String subsidyItem="居民养老保险";

        private String batchNo = "1";

        @JsonProperty("aae019")
        private BigDecimal subsidyAmount;

        @JsonProperty("aae009")
        private String bankAccountName;

        @JsonProperty("aae010")
        private String bankAccount;

        private String bankName = "未知";


    }
}
