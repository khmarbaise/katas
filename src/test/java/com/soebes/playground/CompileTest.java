package com.soebes.playground;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

class CompileTest {

    @Test
    void firstTest() {

        List<Integer> numbers = new ArrayList<Integer>();

        Map<BigDecimal, Long> mapping = new TreeMap<>();

        double resultInDouble = IntStream.range(0, 100).parallel().mapToDouble(s -> s * 0.5).sum();

        System.out.println("resultInDouble = " + resultInDouble);

        int first = ThreadLocalRandom.current()
                                     .ints(1000, 0, 1000)
                                     .filter(s -> s == 500)
                                     .findFirst()
                                     .orElseThrow(() -> new NoSuchElementException("We have not found the right number."));

        System.out.println("first = " + first);
    }
}
