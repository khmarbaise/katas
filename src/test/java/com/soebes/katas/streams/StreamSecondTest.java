package com.soebes.katas.streams;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableList;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamSecondTest {

    @Test
    void jdk7wayOfDoing () {
        List<String> first = Arrays.asList("A", "B", "C");
        List<String> second = Arrays.asList("D", "E", "F");
        List<String> third = Arrays.asList("G", "H", "I");

        List<String> result = new ArrayList<>(first);
        result.addAll(second);
        result.addAll(third);

        List<String> toUnmodifiableList = unmodifiableList(result);

        toUnmodifiableList.forEach(System.out::println);
    }

    @Test
    void jdk8wayOfDoing() {
        List<String> first = List.of("A", "B", "C");
        List<String> second = List.of("D", "E", "F");
        List<String> third = List.of("G", "H", "I");

        List<String> collect = Stream.of(first, second, third)
                                     .flatMap(Collection::stream)
                                     .collect(toUnmodifiableList());

        collect.forEach(System.out::println);
    }

}
