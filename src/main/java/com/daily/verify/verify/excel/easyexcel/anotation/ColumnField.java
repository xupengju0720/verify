package com.daily.verify.verify.excel.easyexcel.anotation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColumnField {
    //被注解的字段名
    private String name;
    //注解中的value
    private String value;
    //注解中的 index
    private int index;
}
