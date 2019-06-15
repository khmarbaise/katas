package com.soebes.katas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class SortingTest {

    private static final List<String> ORDER_STATUS = List.of("FAILURE", "UNSTABLE", "UNKNOWN", "SUCCESS");

    private static final Comparator<String> resultComparator = Comparator.comparingInt(ORDER_STATUS::indexOf);

    private Comparator<String> resultComparator_v2 = (l, r) -> Integer.compare(ORDER_STATUS.indexOf(l), ORDER_STATUS.indexOf(r));

    private List<String> GIVEN_LIST = Arrays.asList("SUCCESS", "SUCCESS", "UNKNOWN", "FAILURE", "UNSTABLE", "UNKNOWN");

    /**
     * Problem:
     *  Sortiere eine Liste anhand einer anderen.
     */
    @Test
    void firstTest() {
        List<String> collect = GIVEN_LIST
                .stream()
                .sorted(resultComparator_v2)
                .collect(Collectors.toList());
    assertThat(collect).containsSequence("FAILURE", "UNSTABLE", "UNKNOWN", "UNKNOWN", "SUCCESS", "SUCCESS");

        collect
                .stream()
                .map(item -> "Item: " + item)
                .forEach(System.out::println);
    }
}
