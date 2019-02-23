package com.soebes.katas.quiz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

public class ListMatchesTest {

    private List<String> x;

    private final static Supplier<Integer> SUP = () -> Integer.valueOf(0);

    @Test
    void firstQuiz() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 1);

        Integer first = listOfIntegers.stream()
                .findFirst()
                .orElseGet(SUP);

        long b = listOfIntegers
                    .stream()
                    .count();


        Integer head = head(listOfIntegers);

    }

    public static <T> T head (List<T> list) {
        return list.stream()
                .skip(list.size() -1 )
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Element not found"));
    }

}
