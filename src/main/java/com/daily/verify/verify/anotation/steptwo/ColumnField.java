package com.daily.verify.verify.anotation.steptwo;

import lombok.Data;

@Data
public class ColumnField {
    private String columnName;
    private String fieldName;
    private char type;

    public ColumnField(String columnName, String fieldName, char type) {
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.type = type;
    }
}
