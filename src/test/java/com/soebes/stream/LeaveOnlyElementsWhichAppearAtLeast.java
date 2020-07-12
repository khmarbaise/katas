package com.soebes.stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LeaveOnlyElementsWhichAppearAtLeast {

  private static final List<String> languages = List.of(
      "Java", "Scala", "Kotlin",
      "Kotlin", "Kotlin", "Ceylon",
      "Groovy", "Groovy", "Kotlin", "Ceylon", "Clojure", "Scala", "Scala", "Groovy"
  );



  /**
   * VIOLATES Predicate definition see JavaDoc:
   * @param atLeast
   * @param <T>
   * @return
   * @see java.util.stream.Stream#filter(Predicate)
   */
  public static <T> Predicate<T> distinct(long atLeast) {
    ConcurrentHashMap<T, Long> map = new ConcurrentHashMap<>();
    return t -> map.merge(t, 1L, Long::sum) == atLeast;
  }

  @Test
  void name() {
    List<String> collect = languages.stream().filter(distinct(3)).collect(Collectors.toList());
    assertThat(collect).containsOnly("Kotlin", "Groovy", "Scala");
  }
}
