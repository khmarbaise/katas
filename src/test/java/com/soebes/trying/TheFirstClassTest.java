package com.soebes.trying;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TheFirstClassTest {

    private static final List<String> XX = List.of("A", "B", "D", "F");
    private static final List<Integer> THE_ELEMENTS_I_CHOOSE = List.of(1, 4, 5, 7, 8, 10);

    @Test
    void thisIsTheFirstMethod() {
        List<String> strings = Arrays.asList("B", "C");

        System.out.println("TheFirstClassTest.thisIsTheFirstMethod");
        for (Integer item : THE_ELEMENTS_I_CHOOSE) {
            System.out.println("item = " + item);
        }
    }

    @Test
    void thisIsTheSecondMethod() {
        System.out.println("TheFirstClassTest.thisIsTheSecondMethod");
        for (Integer i : THE_ELEMENTS_I_CHOOSE) {
            System.out.println("i = " + i);
        }
    }

    @Test
    void thisIsThethirdMethod() {
        for (String item : XX) {
            System.out.println("item = " + item);
        }

        for (int i = 0; i < THE_ELEMENTS_I_CHOOSE.size(); i++) {
            for (int count = 0; count < 10; count++) {
                System.out.println("count = " + count);
            }
            System.out.println("i = " + i);
        }
    }
}
