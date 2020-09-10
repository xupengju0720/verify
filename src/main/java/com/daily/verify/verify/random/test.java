package com.daily.verify.verify.random;


public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtils.getNumberBetween(1000, 9999));
        }
    }
}
