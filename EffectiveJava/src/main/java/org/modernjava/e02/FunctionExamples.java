package org.modernjava.e02;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Vitamindragon
 * @since 2023-07-25
 */
public class FunctionExamples {

    static void functionExample001() {
        final Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        };

        System.out.println(toInt.apply("10"));

        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> identity2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t;
            }
        };
        System.out.println(identity.apply(999));
        System.out.println(identity2.apply(999));


    }

    static void functionExample002() {
        final Function<String, Integer> toInt = (value) -> {
            return Integer.parseInt(value);
        };
        System.out.println(toInt.apply("10"));

        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> identity2 = (t) -> {
            return t;
        };

        System.out.println(identity.apply(999));
        System.out.println(identity2.apply(999));


    }

    static void functionExample003() {
        final Function<String, Integer> toInt = value -> Integer.parseInt(value);
        System.out.println(toInt.apply("10"));

        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> identity2 = t -> t;

        System.out.println(identity.apply(999));
        System.out.println(identity2.apply(999));

    }


    static void consumerExample001() {
        Consumer<String> consumer = value -> System.out.println(value);
        consumer.accept("10");
    }

    public static void main(String[] args) {
//        functionExample001();
//        functionExample002();
//        functionExample003();
          consumerExample001();
    }

}