package com.daily.verify.verify.dynamic.proxy.jdk;

public class SuspenseMovie implements Movie {
    @Override
    public void show() {
        System.out.println("正在播放悬疑电影");
    }
}
