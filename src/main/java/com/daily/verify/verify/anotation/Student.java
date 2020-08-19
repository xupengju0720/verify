package com.daily.verify.verify.anotation;

public class Student {
    @SelfFunctionAnotation(name = "小明", array = {1, 2, 3})
    public void study(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Good Good Study, Day Day Up!");
        }
    }
}
