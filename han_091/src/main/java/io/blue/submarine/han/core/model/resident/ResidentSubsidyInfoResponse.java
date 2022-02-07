package io.blue.submarine.han.core.model.resident;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 居民补助信息请求响应类.
 *
 * @author shucunbin
 * @date 2022-02-06 15:22
 */
@Getter
@Setter
@ToString
public class ResidentSubsidyInfoResponse {
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
        List<ResultSet> resultset;
    }


    @Getter
    @Setter
    static class ResultSet {
        @JsonProperty("aae003")
        private String subsidiesDate;

        @JsonProperty("aac003")
        private String residentName;

        @JsonProperty("item")
        private String subsidyItem;

        @JsonProperty("项目批次")
        private String batchNo;

        @JsonProperty("aae019")
        private BigDecimal subsidyAmount;

        @JsonProperty("aae008")
        private String aae008;

        @JsonProperty("aae009")
        private String bankAccountName;

        @JsonProperty("aaf002")
        private String bankName;

        @JsonProperty("收款银行账号")
        private String bankAccount;
    }
}


