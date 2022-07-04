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
    @ExcelProperty("202110")
    private String ym1;
    @ExcelProperty("202111")
    private String ym2;
    @ExcelProperty("202112")
    private String ym3;
    @ExcelProperty("202201")
    private String ym4;
    @ExcelProperty("202202")
    private String ym5;
    @ExcelProperty("202203")
    private String ym6;
    @ExcelProperty("202204")
    private String ym7;
    @ExcelProperty("202205")
    private String ym8;
    @ExcelProperty("202206")
    private String ym9;
    @ExcelProperty("小计")
    private String subsidyTotalAmount;

}
