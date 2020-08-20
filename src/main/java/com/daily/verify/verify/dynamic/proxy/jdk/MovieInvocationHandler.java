package com.daily.verify.verify.dynamic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MovieInvocationHandler implements InvocationHandler {
    private Object object;

    public MovieInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        showStart();
        Object invoke = method.invoke(object, args);
        showEnd();
        return invoke;
    }

    public void showStart() {
        System.out.println("电影开始前正在播放广告");
    }

    public void showEnd() {
        System.out.println("电影结束了，接续播放广告");
    }
}
