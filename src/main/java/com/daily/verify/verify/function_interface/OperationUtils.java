package com.daily.verify.verify.function_interface;

public class OperationUtils {
    public static Double doOperation(Double opt, Double cpt, CallBackMethod callBackMethod) throws Exception {
        if (null == opt && null == cpt) {
            throw new Exception("方法入参不能为null");
        }
        return callBackMethod.CallBackMethod();
    }
}
