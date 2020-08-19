package com.daily.verify.verify.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解
 * 注解中只能定义注解类型的元素
 * 访问修饰符必须是public 默认是public
 * ()是特殊语法，不能定义参数
 * Target指定那些类型上可以使用 这里指定类、接口和方法上可以用
 * Retention 作用于注解的声明活力 这里声明运行时期使用
 *
 *
 *
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SelfFunctionAnotation {

    String name();

    int age() default 18;

    int[] array();

}
