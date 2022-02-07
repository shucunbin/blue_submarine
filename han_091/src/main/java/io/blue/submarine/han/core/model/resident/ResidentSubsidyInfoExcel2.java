package io.blue.submarine.han.core.model.resident;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 居民补助信息（excel 导出）.
 *
 * @author shucunbin
 * @date 2022-02-07 17:08
 */
@Getter
@Setter
public class ResidentSubsidyInfoExcel2 {
    @ExcelProperty("户主姓名")
    private String residentName;
    @ExcelProperty("补贴类型")
    private String subsidyType;
    @ExcelProperty("补贴项目")
    private String subsidyItem;
    @ExcelProperty("补贴项目全年合计")
    private String subsidyItemTotalAmount;
}
