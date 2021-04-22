package com.daily.verify.verify.observer.jdkpk;

import java.util.Observable;
import java.util.Observer;

public class OddObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg == NumsObservable.ODD) {
            NumsObservable myObserable = (NumsObservable) o;
            System.out.println("OddObserver:Data has changed to "
                    + myObserable.getData());
        }
    }

}