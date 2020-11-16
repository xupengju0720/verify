package com.daily.verify.verify.anotation.steptwo;

import lombok.Data;

@Data
public class Customer implements ColumnFieldMap {
    @DatasetColumn(ColumnName = "t_name")
    public String name;
    @DatasetColumn(ColumnName = "t_code")
    public String code;
    @DatasetColumn(ColumnName = "t_status")
    public String status;
    @DatasetColumn(ColumnName = "t_refer")
    public String refer;

    public Customer(String name, String code, String status, String refer) {
        this.name = name;
        this.code = code;
        this.status = status;
        this.refer = refer;
    }
}
