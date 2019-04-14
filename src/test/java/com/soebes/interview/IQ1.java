package com.soebes.interview;

import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.Map;

import static java.util.Map.entry;

public class IQ1 {

    // Given:
    //  An integer array with 100 elements in it.
    //
    // ToDo:
    //  Find a missing number within the array?

    @Test
    void firstTest() {

        BitSet bs = new BitSet();

        bs.set(0);
        bs.set(1);
        bs.set(2);
        bs.set(3);
        bs.set(5);
        bs.set(22);
        bs.set(32);
        System.out.println("Count:" + bs.stream().count());
//        bs.stream().filter( ).forEach(s -> System.out.println("Bit: " + s));

        int i = bs.nextClearBit(0);

        System.out.println("Index:" + i);
        Map.ofEntries(
            entry("A", 1),
            entry("B", 2),
            entry("C", 3)
        );


        int a = Integer.MAX_VALUE + 1;
        System.out.println("Result: " + a);

        int b = Integer.MIN_VALUE;

        int c = -1 * b;

        System.out.println("Result c:=" + c);
    }
}