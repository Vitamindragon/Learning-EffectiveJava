package org.modernjava.e03_consumer;

import java.util.function.Consumer;

/**
 * @author Vitamindragon
 * @since 2023-07-26
 */
public class ConsumerExamples {

    public static void consumerExamples() {
        final Consumer<String> print = value -> System.out.println(value);
        print.accept("hello");

        final Consumer<String> greetings = value -> System.out.println("Hello " + value);
        greetings.accept("World");
        greetings.accept("Kevin");
    }

    public static void main(String[] args) {
        consumerExamples();
    }
}