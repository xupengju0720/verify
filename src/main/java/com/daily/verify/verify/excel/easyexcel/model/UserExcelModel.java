package com.daily.verify.verify.excel.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExcelModel extends BaseRowModel implements Serializable {

    @ExcelProperty(value = "user_name", index = 0)
    private String name;

    @ExcelProperty(value = "user_age", index = 1)
    private Integer age;

    @ExcelProperty(value = "user_phone", index = 2)
    private String mobile;

    @ExcelProperty(value = "user_sex", index = 3)
    private String sex;
}
