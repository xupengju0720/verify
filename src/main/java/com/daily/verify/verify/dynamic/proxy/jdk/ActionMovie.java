package com.daily.verify.verify.dynamic.proxy.jdk;

public class ActionMovie implements Movie {
    @Override
    public void show() {
        System.out.println("正在播放动作电影");
    }
}
