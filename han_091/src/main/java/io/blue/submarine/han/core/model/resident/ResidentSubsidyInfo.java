package io.blue.submarine.han.core.model.resident;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 居民补助信息.
 *
 * @author shucunbin
 * @date 2022-02-06 14:36
 */
@Getter
@Setter
public class ResidentSubsidyInfo {
    /**
     * 户编号
     */
    @JsonProperty("household_id")
    private String householdId;

    /**
     * 户角色
     */
    @JsonProperty("household_role")
    private String householdRole;

    /**
     * 居民身份证号
     */
    @JsonProperty("resident_id")
    private String residentId;

    /**
     * 居民姓名
     */
    @JsonProperty("resident_name")
    private String residentName;

    /**
     * 补助类别
     */
    @JsonProperty("subsidy_type")
    private String subsidyType;

    /**
     * 补助项目名称
     */
    @JsonProperty("subsidy_item")
    private String subsidyItem;

    /**
     * 补助项目批次
     */
    @JsonProperty("subsidy_batch_no")
    private String subsidyBatchNo;

    /**
     * 补助金额
     */
    @JsonProperty("subsidy_amount")
    private BigDecimal subsidyAmount;

    /**
     * 发放补助账号所属银行
     */
    @JsonProperty("bank_name")
    private String bankName;

    /**
     * 发放补助银行账号所有人名称
     */
    @JsonProperty("bank_account_name")
    private String bankAccountName;

    /**
     * 发放补助银行账号
     */
    @JsonProperty("bank_account")
    private String bankAccount;

    /**
     * 发放补助日期
     */
    @JsonProperty("subsidies_date")
    private String subsidiesDate;

    /**
     * 发放补助状态
     */
    @JsonProperty("subsidies_status")
    private Integer subsidiesStatus;

    /**
     * 记录创建时间
     */
    @JsonProperty("create_time")
    private Long createTime;

    /**
     * 记录更新时间
     */
    @JsonProperty("update_time")
    private Long updateTime;
}
