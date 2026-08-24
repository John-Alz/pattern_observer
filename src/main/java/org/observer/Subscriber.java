package org.observer;

public interface Subscriber<T> {

    void onNext(T next);
    String getName();

}
