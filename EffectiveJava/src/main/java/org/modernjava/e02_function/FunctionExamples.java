package org.modernjava.e02_function;

import java.util.function.Function;

/**
 * @author Vitamindragon
 * @since 2023-07-25
 */
public class FunctionExamples {

    private static void functionExamplesBefore() {
        final Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        };
        final Integer number = toInt.apply("100");
        System.out.println(number);

        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> identity2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer value) {
                return value;
            }
        };


        System.out.println(identity.apply(999));
        System.out.println(identity2.apply(999));


    }


    private static void functionExamplesAfter() {
        final Function<String, Integer> toInt = value-> Integer.parseInt(value);
        final Integer number = toInt.apply("100");
        System.out.println(number);

        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> identity2 = t->t;


        System.out.println(identity.apply(999));
        System.out.println(identity2.apply(999));


    }

    public static void main(String[] args) {

        functionExamplesBefore();
        functionExamplesAfter();

    }
}