package com.soebes.stream;

import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.toSet;

class XTest {

  public static <T, R> Set<R> findDuplicatesWith(Collection<? extends T> collection,
                                                 Function<? super T, ? extends R> mapper) {
    Set<R> uniques = new HashSet<>();
    return collection.stream().map(mapper).filter(e -> !uniques.add(e)).collect(toSet());
  }

  private <U, T> Set<T> findDuplicates(Collection<T> collection, Function<? super T, ? extends U> keyExtractor) {
    Map<U, T> uniques = new HashMap<>();
    return collection.stream().filter(e -> uniques.put(keyExtractor.apply(e), e) != null).collect(toSet());
  }

  private <T> List<T> collectDuplicates(Collection<T> collection) {
    return collection.stream()
      .distinct()
      .filter(entry -> Collections.frequency(collection, entry) > 1)
      .collect(Collectors.toList());
  }

  @Test
  void findDuplicates() {
    List<P> existingList = List.of(new P("A", 1), new P("B", 5), new P("C", 12), new P("B", 5));

    Set<P> duplicates = findDuplicates(existingList, P::getName);
    System.out.println("duplicates = " + duplicates);
  }

  @Test
  void groupingBy() {
    List<P> existingList = List.of(new P("A", 1), new P("B", 5), new P("C", 12), new P("B", 5));
    List<P> duplicates = groupingBy(existingList, P::getName);
    System.out.println("duplicates = " + duplicates);
  }

  @Test
  void self_grouping_by() {
    List<P> existingList = List.of(new P("C", 12), new P("A", 1), new P("B", 6), new P("A", 5),
      new P("B", 5));

    List<P> duplicates = groupingBySelf(existingList, P::getName);
    System.out.println("duplicates = " + duplicates);
  }

  @Test
  void group_by_counting() {
    List<P> existingList = List.of(new P("A", 1), new P("B", 6), new P("A", 5), new P("C", 12));
    List<P> duplicates = existingList.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .filter(p -> p.getValue() > 1)
        .map(Entry::getKey)
        .toList();

    System.out.println("collect = " + duplicates);
  }

  private <T, R> List<T> groupingBySelf(Collection<T> collection, Function<T, R> keyExtractor) {
    return collection.stream()
      .collect(Collectors.groupingBy(keyExtractor::apply))
      .entrySet()
      .stream()
      .filter(e -> e.getValue().size() > 1)
      .flatMap(s -> s.getValue().stream())
      .collect(Collectors.toList());
  }

  // PE CS
  // Producer Extends
  // Consumer Super
  private <T, R> List<T> groupingBy(Collection<T> collection, Function<? super T, ? extends R> keyExtractor) {
    return collection.stream()
      .collect(Collectors.groupingBy(keyExtractor::apply))
      .entrySet()
      .stream()
      .filter(e -> e.getValue().size() > 1)
      .flatMap(e -> e.getValue().stream())
      .collect(Collectors.toList());
  }


  @Test
  void collectDuplicates() {
    List<P> existingList = List.of(new P("A", 1), new P("B", 5), new P("A", 1), new P("C", 12), new P("B", 5));
    List<P> duplicates = collectDuplicates(existingList);
    System.out.println("duplicates = " + duplicates);
  }

  @Test
  void collect_duplikation() {
    List<P> existingList = List.of(new P("A", 1), new P("B", 5), new P("A", 1), new P("C", 12), new P("B", 5));
    Set<String> duplicates = findDuplicatesWith(existingList, P::getName);
    System.out.println("duplicates = " + duplicates);
  }

  @Test
  void groupingBy_SubGroups() {
    List<P> existingList = List.of(new P("A", 1), new P("B", 5), new P("A", 1), new P("C", 12), new P("B", 5));
    var collect = existingList.stream()
      .collect(Collectors.groupingBy(P::getName, averagingDouble(P::getAge)));

    collect.entrySet().stream().forEach(item -> System.out.println("item = " + item));
  }

  @Test
  void partitioning_by() {
    List<P> existingList = List.of(new P("A", 1), new P("B", 5), new P("A", 1), new P("C", 12), new P("B", 5));
    var collect = existingList.stream().collect(Collectors.groupingBy(P::getAge));

    collect.entrySet().stream().forEach(item -> System.out.println("item = " + item));
  }

}
