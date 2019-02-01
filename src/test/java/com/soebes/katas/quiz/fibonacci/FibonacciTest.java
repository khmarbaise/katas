package com.soebes.katas.quiz.fibonacci;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

class FibonacciTest {

    private static UnaryOperator<int[]> NEXT_ELEMENT = x -> new int[] {x[1], x[0]+x[1]};

    @Test
    void fibonacciTest() {
        Stream.iterate(new int[]{0, 1}, NEXT_ELEMENT)
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }

    @Test
    void name() {
        Stream.iterate(0, n -> n+2).limit(200).forEach(s -> System.out.println("Value:" + s));
    }
}
