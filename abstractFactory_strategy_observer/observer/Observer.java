package com.service.observer;

public interface Observer<T> {
    void update(T op);//传入参数
}
