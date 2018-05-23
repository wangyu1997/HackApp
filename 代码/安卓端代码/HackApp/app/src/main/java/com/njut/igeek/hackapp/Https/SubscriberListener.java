package com.njut.igeek.hackapp.Https;

public interface SubscriberListener<T> {
    void onNext(T t);

    void onError();
}