package com.daily.verify.verify.random;

public class RandomUtils {

    public static Long getNumberBetween(int start, int end) {
        if (end < start) {
            int temp = start;
            start = end;
            end = temp;
        }
        double random = Math.random() * (end - start);
        return Math.round(random) + start;
    }
}
