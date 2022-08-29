package com.soebes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalTest {

  public static final String NON_NULL_VALUE = "NON_EMPTY";

//  String first_method(Optional<String> value) {
//    return value.ifPresentOrElse(s -> {},
//        () -> {
//          return "";
//        });
//  }
//
//  @Test
//  void name() {
//    Optional<String> oV = Optional.ofNullable(NON_NULL_VALUE);
//  }


  @Test
  void name() {
    int[] intArray = new int[]{2,3,5};
    int sum = Arrays.stream(intArray).sum();
    assertThat(sum).isEqualTo(10);
  }

  @Test
  void stream_min() {
    int[] intArray = new int[]{2,3,5};
    int sum = Arrays.stream(intArray).min().orElse(0);
  }
  @Test
  void stream_max() {
    int[] intArray = new int[]{2,3,5};
    int sum = Arrays.stream(intArray).max().orElse(0);
  }

  @Test
  void second() {
    List<Integer> integers = List.of(10, 1, 3, 5, 7, 9);
    Optional<Integer> or = integers.stream()
        .takeWhile(i -> i > 5)
        .peek(integer -> System.out.println("takeWhile = " + integer))
        .dropWhile(i -> i > 9)
        .peek(integer -> System.out.println("dropWhile = " + integer))
        .findFirst()
        .or(() -> Optional.of(777));
    System.out.println("or = " + or);
  }
  @Test
  void third() {
    List<Integer> integers = List.of(1, 3, 5, 7, 9, 10);
    List<Integer> or = integers.stream()
        .takeWhile(i -> i > 5).toList();
    or.forEach(System.out::println);
  }
  @Test
  void forth() {
    List<Integer> integers = List.of(10, 1, 3, 5, 7, 9);
    List<Integer> or = integers.stream()
        .takeWhile(i -> i > 5).toList();
    or.forEach(System.out::println);
  }

  record Activity(String name) {

  }
  @Test
  void fivth() {
    var strings = Set.of("A", "B", "C");

    var collect = Optional.ofNullable(strings).orElse(Set.of()).stream().map(s -> {
      var activity = new Activity(s);
      return activity;
    }).collect(Collectors.toSet());

  }

  @Test
  void testing_optional_int() {
    var optionalInt = OptionalInt.of(10);
    var empty = OptionalInt.empty();

    var i = optionalInt.orElse(-1);
  }

  @Test
  void testing_optional_long() {
    var optionalLong = OptionalLong.of(10L);
    var empty = OptionalLong.empty();
    var l = optionalLong.orElse(-10L);
  }
}
