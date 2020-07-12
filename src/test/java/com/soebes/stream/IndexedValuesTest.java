package com.soebes.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class IndexedValuesTest {

  private static final List<String> TheList = List.of("Good", "Old", "Stream", "API");

  public static <T> Stream<IndexedValue<T>> withIndicies(List<T> list) {
    return IntStream.range(0, list.size()).mapToObj(idx -> new IndexedValue<>(idx, list.get(idx)));
  }

  @Test
  void name() {

  }

  static class IndexedValue<T> {
    private final int index;
    private final T value;

    public IndexedValue(int index, T value) {
      this.index = index;
      this.value = value;
    }

    public T getValue() {
      return value;
    }

    public int getIndex() {
      return index;
    }
  }
}
