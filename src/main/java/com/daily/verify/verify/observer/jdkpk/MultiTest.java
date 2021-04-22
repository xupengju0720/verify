package com.daily.verify.verify.observer.jdkpk;

public class MultiTest {
    /**
     * @param args
     */
    public static void main(String[] args) {

        NumsObservable number = new NumsObservable();
        number.addObserver(new OddObserver());
        number.addObserver(new EvenObserver());
        number.setData(1);
        number.setData(2);
        number.setData(3);

    }

}
