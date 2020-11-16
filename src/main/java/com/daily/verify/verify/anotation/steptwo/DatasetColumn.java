package com.daily.verify.verify.anotation.steptwo;

import java.lang.annotation.*;


@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface DatasetColumn {

    char ColumnType() default 'S';

    String ColumnName();

}
