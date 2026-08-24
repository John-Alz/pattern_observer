package org.observer;

import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {

        final ReactiveStream<String> stringReactiveStream = new ReactiveStream<>(); // Publisher
        final ReactiveStream<Integer> integerReactiveStream = new ReactiveStream<>(); // Publisher

        final String subsName1 = "Subscriber1";
        final String subsName2 = "Subscriber2";
        final String subsName3 = "Subscriber3";
        final String subsName4 = "Subscriber4";

        // Subscriber for stringReactiveStream
        final Subscriber<String> stringSubscriber1 = new SubscriberImpl<>(
                str -> "Length: " + str.length(),
                subsName1
        );

        // Subscriber for stringReactiveStream
        final Subscriber<String> stringSubscriber2 = new SubscriberImpl<>(
                str -> "UpperCase: " + str.toUpperCase(),
                subsName2
        );

        // Subscriber for integerReactiveStream
        final Subscriber<Integer> integerSubscriber1 = new SubscriberImpl<>(
                num -> "Value: " + num,
                subsName3
        );

        // Subscriber for integerReactiveStream
        final Subscriber<Integer> integerSubscriber2 = new SubscriberImpl<>(
                num -> "Raiz cuadrada: " + num * num,
                subsName4
        );

        stringReactiveStream
                .subscribe(stringSubscriber1)
                .subscribe(stringSubscriber2);

        integerReactiveStream
                .subscribe(integerSubscriber1)
                .subscribe(integerSubscriber2);

        log.info("---[Strings]---");
        stringReactiveStream.emit("Hola mundo");
        stringReactiveStream.emit("esto es un suscriptor");
        stringReactiveStream.emit("Desarrollo web");

        log.info("---[Numbers]---");
        integerReactiveStream.emit( 7);
        integerReactiveStream.emit( 5);
        integerReactiveStream.emit( 60);

        stringReactiveStream.unSubscribe(stringSubscriber2);

        integerReactiveStream.unSubscribe(integerSubscriber1);
        integerReactiveStream.unSubscribe(integerSubscriber2);

//        integerReactiveStream.emit(9);

    }
}