package io.blue.submarine.han.core.model.resident;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 居民信息.
 *
 * @author shucunbin
 * @date 2022-02-06 18:55
 */
@Getter
@Setter
@ToString
public class ResidentInfo {
    /**
     * 户编号
     */
    @ExcelProperty(index = 5)
    private String householdId;

    /**
     * 居民身份证号
     */
    @ExcelProperty(index = 8)
    private String residentId;

    /**
     * 居民姓名
     */
    @ExcelProperty(index = 7)
    private String residentName;

    /**
     * 户角色
     */
    @ExcelProperty(index = 10)
    private String householdRole;



    /**
     * 居民健康状况
     */
    @ExcelProperty(index = 14)
    private String healthStatus;
}
