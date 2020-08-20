package com.daily.verify.verify.dynamic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 基于jdk的InvocationHandler 面向接口的动态代理 示例
 */
public class test {
    public static void main(String[] args) {
        ActionMovie movie = new ActionMovie();
        InvocationHandler invocationHandler = new MovieInvocationHandler(movie);
        Movie dynamicAction = (Movie) Proxy.newProxyInstance(Movie.class.getClassLoader(), ActionMovie.class.getInterfaces(), invocationHandler);
        dynamicAction.show();


        SuspenseMovie SusMovie = new SuspenseMovie();
        InvocationHandler SusHandler = new MovieInvocationHandler(SusMovie);
        Movie SusAction = (Movie) Proxy.newProxyInstance(Movie.class.getClassLoader(), ActionMovie.class.getInterfaces(), SusHandler);
        SusAction.show();

    }
}
