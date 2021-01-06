package com.daily.verify.verify.function_interface;

//加法运算测试
public class Test {
    public static void main(String[] args) throws Exception {
        RealServiceInterfaceImpl realServiceInterface = new RealServiceInterfaceImpl();
        System.out.println(realServiceInterface.operation(1.0, 1.1));
    }
}
