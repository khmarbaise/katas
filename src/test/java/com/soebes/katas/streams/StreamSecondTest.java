package com.soebes.katas.streams;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;


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
    void jdk8wayOftDoing() {
        List<String> first = List.of("A", "B", "C");
        List<String> second = List.of("D", "E", "F");
        List<String> third = List.of("G", "H", "I");

        List<String> collect = Stream.of(first, second, third)
                                     .flatMap(Collection::stream)
                                     .collect(toUnmodifiableList());

        collect.forEach(System.out::println);
    }

}
