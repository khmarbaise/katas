package com.soebes.stream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

class CartesianProductTest {

  @Nested
  class FirstApproach {
    Stream<String> s1 = Stream.of("Lawful", "Neutral", "Chaotic");
    Stream<String> s2 = Stream.of("Good", "Neutral", "Evil");

    @Test
    void this_solution_will_fail() {
      s1.flatMap(a -> s2.map(b -> a + " " + b)).forEach(System.out::println);
    }
  }

  @Nested
  class SecondApproach {
    List<List<String>> input = List.of(
        List.of("Lawful", "Neutral", "Chaotic"),
        List.of("Simple", "Unknown", "Complex"),
        List.of("Good", "Neutral", "Evil")
    );

    Supplier<Stream<String>> s1 = () -> Stream.of("Lawful", "Neutral", "Chaotic");
    Supplier<Stream<String>> s2 = () -> Stream.of("Good", "Neutral", "Evil");

    Stream<Supplier<Stream<String>>> streamOfStreamSuppliers = input.stream().map(item -> item::stream);
    Supplier<Stream<String>> result = streamOfStreamSuppliers.reduce(
        (s1, s2) ->
            () -> s1.get().flatMap(a -> s2.get().map(b -> a + " " + b))).orElse(() -> Stream.of("-"));

    @Test
    void name() {
      result.get().forEach(System.out::println);
    }
  }
}
