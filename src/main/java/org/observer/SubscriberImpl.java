package org.observer;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.util.function.Function;

@Log
@AllArgsConstructor
public class SubscriberImpl<T> implements Subscriber<T> {

    private final Function<T, String> mapper;
    private final String name;

    @Override
    public void onNext(T next) {
        log.info("[onNext] " + next);
        final var valueMapped = this.mapper.apply(next);
        log.info("[onNext] Mapped " + valueMapped);
    }

    @Override
    public String getName() {
        return this.name;
    }

}
