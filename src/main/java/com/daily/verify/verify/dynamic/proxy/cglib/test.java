package com.daily.verify.verify.dynamic.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * 测试 cglib 动态代理
 */
public class test {

    public static void main(String[] args) {
        // //在指定目录下生成动态代理类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(HorrorMovie.class);
        //设置回调函数
        enhancer.setCallback(new CglibProxyInterceptor());
        //这里的creat方法就是正式创建代理类
        HorrorMovie horrorMovie = (HorrorMovie) enhancer.create();
        //调用代理类的play方法
        horrorMovie.play();
        System.out.println("cglib动态代理 ：" + horrorMovie.getClass());


        Enhancer enhancer1 = new Enhancer();
        enhancer1.setSuperclass(MilitaryMovie.class);
        //设置回调函数
        enhancer1.setCallback(new CglibProxyInterceptor());
        //这里的creat方法就是正式创建代理类
        MilitaryMovie militaryMovie = (MilitaryMovie) enhancer1.create();
        //调用代理类的play方法
        militaryMovie.play();
        System.out.println("cglib动态代理 ：" + militaryMovie.getClass());
    }
}
