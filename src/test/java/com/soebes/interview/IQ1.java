package com.soebes.interview;

import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.stream.IntStream;

public class IQ1 {


    // Given:
    //  An integer array with 100 elements in it.
    //
    // ToDo:
    //  Find a missing number within the array?

    @Test
    void firstTest() {

        BitSet bs = new BitSet();

        bs.set(5);
        bs.set(22);
        bs.stream().forEach(s -> System.out.println("Bit: " + s));
    }
}
