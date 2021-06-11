package com.service.observer;

public class NoticeSubjectOrder implements SubjectOrder {

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(Object param) {
        // 通知订阅者们
        for (Observer observer : observers) {
            observer.update(param);
        }
    }
}
