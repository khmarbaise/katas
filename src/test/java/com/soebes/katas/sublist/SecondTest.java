package com.soebes.katas.sublist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;


class SecondTest {

    @Test
    void testName()
            throws Exception {
        HashMap<String, Long> x = new HashMap<>();

        LongStream.range(1, 100L).forEach( // Long m
                m -> x.putIfAbsent(String.valueOf(m), m));

//	for (long m = 1; m < 100; m++) {
//	    String ms = String.valueOf(m);
//	    if (!x.containsKey(ms)) {
//		x.put(ms, m);
//	    }
//	}

//        x.entrySet() //
//         .stream() //
//         .forEach( //
//                   entry -> System.out.println( "K:" + entry.getKey() + " V:" + entry.getValue() ) );

    }

    @Test
    void secondTest() {
        HashSet<String> x = new HashSet<>();
        x.removeIf(f -> f.contains("x"));
    }

}

