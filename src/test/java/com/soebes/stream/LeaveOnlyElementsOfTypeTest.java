package com.soebes.stream;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.stream.Stream;

class LeaveOnlyElementsOfTypeTest {

  public static <T, R> Function<T, Stream<R>> select(Class<R> clazz) {
    return e -> clazz.isInstance(e) ? Stream.of(clazz.cast(e)) : null;
  }

  @Test
  void first_xx() {
    //IntStream.range(0, nodeList).mapToObj(nodeList::item).flatMap(select(Element.class));
  }

}
