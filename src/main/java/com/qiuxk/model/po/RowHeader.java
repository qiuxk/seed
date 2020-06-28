package com.qiuxk.model.po;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * excel的表头
 *
 * @author qiuxk
 * @classes com.qiuxk.model.po.RowHeader
 * @date 2020-06-28 11:27
 */
@Data
public class RowHeader extends BaseRowModel {

    @ExcelProperty(value = "学生姓名",index = 0)
    private String name;

    @ExcelProperty(value = "学生年龄",index = 1)
    private Integer age;

    @ExcelProperty(value = "学生性别",index = 2)
    private String sex;
}
