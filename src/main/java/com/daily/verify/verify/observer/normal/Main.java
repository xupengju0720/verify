package com.daily.verify.verify.observer.normal;

public class Main {
    public static void main(String[] args) {
        //声明一个动物园管理员 相当于中间调节管理类
        Zoo zoo = new Zoo();
        //声明一个监听类  并且注册进Zoo里
        zoo.registerAnimalAddedListener(new PrintNameAnimalAddedListener());
        //添加一个动物  调节类去通知所有已经注册进的监听类
        zoo.addAnimal(new Animal("Tiger"));
    }
}
