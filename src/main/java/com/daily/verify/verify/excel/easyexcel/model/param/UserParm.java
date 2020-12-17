package com.daily.verify.verify.excel.easyexcel.model.param;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserParm extends BaseRowModel implements Serializable {
    //数据类型 第一位
    @ExcelProperty(value = "数据类型")
    private String data_type;
    //补充字段 第二位
    @ExcelProperty(value = "对比结果")
    private String compare_result;
    //测试用例编号
    @ExcelProperty(value = "测试用例编号")
    private String specialCode;

    @ExcelProperty(value = "user_name")
    private String name;

    @ExcelProperty(value = "user_age")
    private Integer age;

    @ExcelProperty(value = "user_phone")
    private String mobile;

    @ExcelProperty(value = "user_sex")
    private String sex;

    @ExcelProperty(value = "失败原因")
    private String msg;
}
