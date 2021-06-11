package com.service.factory;


public interface AbstarctFactory<T1,T2> {

    T1 create(T2 param);

}
