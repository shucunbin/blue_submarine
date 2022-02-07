package io.blue.submarine.han.core.model.resident;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 居民补助信息（excel 导出）.
 * @author shucunbin
 * @date 2022-02-07 14:28
 */
@Getter
@Setter
public class ResidentSubsidyInfoExcel {
    @ExcelProperty("户主姓名")
    private String residentName;
    @ExcelProperty("补贴类型")
    private String subsidyType;
    @ExcelProperty("202010")
    private String ym1;
    @ExcelProperty("202011")
    private String ym2;
    @ExcelProperty("202012")
    private String ym3;
    @ExcelProperty("202101")
    private String ym4;
    @ExcelProperty("202102")
    private String ym5;
    @ExcelProperty("202103")
    private String ym6;
    @ExcelProperty("202104")
    private String ym7;
    @ExcelProperty("202105")
    private String ym8;
    @ExcelProperty("202106")
    private String ym9;
    @ExcelProperty("202107")
    private String ym10;
    @ExcelProperty("202108")
    private String ym11;
    @ExcelProperty("202109")
    private String ym12;
    @ExcelProperty("小计")
    private String subsidyTotalAmount;

}
