package com.daily.verify.verify.aop.anotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface CompareDbDataAfterImport {
    String description() default "";//描述

    String type();//描述
}
