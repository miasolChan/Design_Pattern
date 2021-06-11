package com.service.observer;

import java.util.ArrayList;
import java.util.List;

public interface SubjectOrder {
    // 观察者列表
    List<Observer> observers = null;

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Object param);

}
