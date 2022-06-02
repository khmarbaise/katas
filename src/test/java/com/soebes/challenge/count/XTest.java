package com.soebes.challenge.count;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class XTest {

  private List<Integer> integers;

  @BeforeEach
  void setUp() {
    this.integers = List.of(1, 2, 5, 4, 2, 6, 8, 9, 1, 5, 1);
  }

  @Test
  @DisplayName("Using groupingBy and a Map.")
  void first_approach() {
    var collect = integers.stream()
        .collect(Collectors.groupingBy(Integer::intValue))
        .entrySet()
        .stream()
        .sorted((c1, c2) -> Integer.compare(c2.getValue().size(), c1.getValue().size())).toList();

    collect.forEach(s -> System.out.println(" K:" + s.getKey() + " #" + s.getValue().size()));
  }

  @Test
  @DisplayName("Using groupingBy and comparing(... Comparator.reverseOrder())..")
  void second_approach() {
    var collect = integers.stream()
        .collect(Collectors.groupingBy(Integer::intValue))
        .entrySet()
        .stream()
        .sorted(Comparator.comparing(s -> s.getValue().size(), Comparator.reverseOrder())).toList();

    collect.forEach(s -> System.out.println(" K:" + s.getKey() + " #" + s.getValue().size()));
  }

  private final Supplier<TreeMap> mapFactor = () -> new TreeMap<List<Integer>, Integer>(Comparator.comparingInt(List::size));

  private final Supplier<TreeMap> b = TreeMap::new;

  @Test
  void third_approach() {
//    var sortedResult = integers.stream()
//        .collect(Collectors.groupingBy(List::size, mapFactor, Collectors.mapping(Collectors.toList(), Integer::intValue)));
//
////    sortedResult.forEach((key, value) -> System.out.println(" K:" + key + " #" + value.size()));
//
    var listIntegerTreeMap = new TreeMap<List<Integer>, Integer>(Comparator.comparing(List::size, Comparator.reverseOrder()));

    listIntegerTreeMap.put(List.of(1), 2);
    listIntegerTreeMap.put(List.of(1,1), 3);
    listIntegerTreeMap.put(List.of(5,5,5,5), 5);

    listIntegerTreeMap.forEach((k,v) -> System.out.println(" k:" + k.size() + " v" + v));
  }

  static final class Item {
    private final int value;
    private final int count;

    Item(int value, int count) {
      this.value = value;
      this.count = count;
    }

    public int value() {
      return value;
    }

    public int count() {
      return count;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) return true;
      if (obj == null || obj.getClass() != this.getClass()) return false;
      var that = (Item) obj;
      return this.value == that.value &&
          this.count == that.count;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, count);
    }

  }

  @Test
  void XXXsecond_approach() {
    var integerIntegerTreeMap = new TreeMap<Integer, Integer>();
    for (Integer integer : integers) {
      var orDefault = integerIntegerTreeMap.computeIfAbsent(integer, 1);
    }

    var collect = integers.stream().map(s -> new Item(s, 1)).collect(Collectors.groupingBy(s -> s.count));

  }
}
