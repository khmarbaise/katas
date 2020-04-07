package com.soebes.katas.quiz.pythagoras;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class PythagorasTest {

    static final BiFunction<Integer, Integer, Double> Squared = (a, b) -> Math.sqrt(a * a + b * b);

    static final DoubleFunction<Boolean> DIVIDER = (t) -> t % 1.0 == 0;

    @Test
    void testName() {

        Stream<Pythagoras> result = IntStream
                .rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream
                        .rangeClosed(a, 100)
                        .filter(b -> DIVIDER.apply(Squared.apply(a, b)))
                        .mapToObj(
                                b -> new Pythagoras(a, b, Squared.apply(a, b).intValue())));

        result.forEach(t -> System.out.println(t));
    }

    static final Predicate<Integer> EVEN = s -> s % 2 == 0;
    static final Predicate<Integer> ODD = s -> s % 3 == 0;

    @Test
    void thisIsAnotherTest() {
        List<Integer> collect = IntStream.rangeClosed(1, 1000)
          .boxed()
          .filter(EVEN.and(ODD))
          .collect(Collectors.toList());

        collect.stream().forEach(integer -> System.out.println("integer = " + integer));
    }
}
