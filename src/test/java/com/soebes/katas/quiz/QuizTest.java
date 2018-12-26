package com.soebes.katas.quiz;

import static java.util.stream.Collectors.toList;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuizTest {

    @Test
    void quiz52_a() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5);
        // return the list of quares
        List<Integer> result = listOfIntegers.stream()
                                             .map(n -> n * n)
                                             .collect(toList());
        result.forEach(v -> System.out.println("Value:" + v));
    }

    @Test
    void quiz52_b() {
        // given:
        // 1,2,3 and 3,4
        // 1,3, 1,4, 2,3, 2,4, 3,3, 3,4
        List<Integer> listOfIntegers = List.of(1, 2, 3);
        List<Integer> secondListOfIntegers = List.of(3, 4);

        List<int[]> stream = listOfIntegers.stream()
                                           .flatMap(v -> secondListOfIntegers.stream()
                                                                             .map(j -> new int[]{v, j})
                                           )
                                           .collect(toList());

        stream.stream()
              .forEach(v -> System.out.println("v:" + v.length + " 0:" + v[0] + " 1:" + v[1]));

    }

    @Test
    void quiz53() {
        List<Integer> integers = List.of(1, 4, 7, 9, 10);
        Integer reduce = integers.stream()
                                 .map(d -> 1)
                                 .reduce(0, (a, b) -> a + b);

        boolean machtes = integers.stream()
                                  .peek(d -> System.out.println("d:" + d))
                            .anyMatch(d -> d == 1);

        System.out.println("Matches: " + machtes);
        System.out.println("reduce:" + reduce);

    }
}
