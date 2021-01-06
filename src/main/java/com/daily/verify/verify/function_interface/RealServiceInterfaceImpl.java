package com.daily.verify.verify.function_interface;

public class RealServiceInterfaceImpl {

    public double operation(double opt, double cpt) throws Exception {
        Double aDouble = OperationUtils.doOperation(opt, cpt, () -> {
            return opt + cpt;
        });
        return aDouble;
    }
}
