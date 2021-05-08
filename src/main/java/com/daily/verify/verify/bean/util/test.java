package com.daily.verify.verify.bean.util;

public class test {
    public static void main(String[] args) {
        Student student = new Student();
        GenericReflexUtils.setValue(student, "name", "zhangsan");
        String name = (String) GenericReflexUtils.getValue(student, "name");
        System.out.println(name);
    }
}
