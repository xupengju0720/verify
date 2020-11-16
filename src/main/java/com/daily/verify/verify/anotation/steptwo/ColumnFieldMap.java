package com.daily.verify.verify.anotation.steptwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ColumnFieldMap {
    Map<String, ColumnField[]> cache = new HashMap<>();

    default ColumnField[] map() {
        return cache.computeIfAbsent(this.getClass().getName(), (s) -> {
            ColumnField[] cfm = (ColumnField[]) ((List) Arrays.asList(this.getClass().getDeclaredFields()).stream().filter((field) -> {
                return field.isAnnotationPresent(DatasetColumn.class);
            }).map((field) -> {
                DatasetColumn dc = field.getAnnotation(DatasetColumn.class);
                return new ColumnField(field.getName(), dc.ColumnName(), dc.ColumnType());
            }).collect(Collectors.toList())).toArray(new ColumnField[0]);
            Map<String, ColumnField> map = new HashMap();
            ColumnField[] var4 = cfm;
            int var5 = cfm.length;
            for (int var6 = 0; var6 < var5; ++var6) {
                ColumnField mapper = var4[var6];
                ColumnField m = (ColumnField) map.putIfAbsent(mapper.getColumnName(), mapper);
                if (m != null) {
                    throw new IllegalStateException(String.format("error message!"));
                }
            }
            return cfm;
        });
    }


}
