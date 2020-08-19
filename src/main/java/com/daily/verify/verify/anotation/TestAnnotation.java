package com.daily.verify.verify.anotation;

import java.lang.reflect.Method;

/**
 * 使用反射拿取注解值
 */
public class TestAnnotation {
    public static void main(String[] args) {
        try {
            //获取Student的Class对象
            Class stuClass = Class.forName("com.daily.verify.verify.anotation.Student");
            //说明一下，这里形参不能写成Integer.class，应写为int.class
            Method stuMethod = stuClass.getMethod("study", int.class);
            //判断是否使用定义的注解
            if (stuMethod.isAnnotationPresent(SelfFunctionAnotation.class)) {
                System.out.println("Student类 study方法上配置了SelfFunctionAnotation注解！");
                //获取该元素上指定类型的注解
                SelfFunctionAnotation selfFunctionAnotation = stuMethod.getAnnotation(SelfFunctionAnotation.class);
                System.out.println("name: " + selfFunctionAnotation.name() + ", age: " + selfFunctionAnotation.age()
                        + ", score: " + selfFunctionAnotation.array()[0]);
            } else {
                System.out.println("Student类 study方法上没有配置SelfFunctionAnotation注解！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
