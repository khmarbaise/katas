package com.soebes.katas.functions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionTest {

  public static Predicate<String> ONLY_A = s -> s.contains("A");
  public static Predicate<String> ONLY_B = s -> s.contains("B");
  static List<Integer> LIST_OF_INTS = List.of(1, 2, 5, 7, 8, 9, 10);
  List<String> LIST_OF_STRINGS = List.of("1", "2", "5", "7", "8", "9", "10");

  static String mapFunction(String in) {
    return "Prefix: " + in;
  }

  // Non Lambda:
  static Function<Integer, Integer> compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
    return new Function<Integer, Integer>() {
      public Integer apply(Integer arg) {
        return f1.apply(f2.apply(arg));
      }
    };
  }

  static Function<Integer, Integer> composeLambda(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
    return arg -> f1.apply(f2.apply(arg));
  }

  @Test
  public void testForInitializers() {
    Function<Integer, Integer> tripple = x -> x * 3;

    System.out.println(tripple.apply(10));
  }

  @Test
  public void testXXX() {
    Function<Integer, Function<Integer, Integer>> tripple = x -> y -> x + y;

    System.out.println(tripple.apply(10).apply(5));
  }

  @Test
  public void testFunctionsWithMap() {
    List<String> collect = Stream.of("A", "B", "C", "D", "E")
      .filter(ONLY_A.or(ONLY_B))
      .map(FunctionTest::mapFunction)
      .collect(toList());

    assertThat(collect).hasSize(2);
    assertThat(collect).containsExactly("Prefix: A", "Prefix: B");
  }

  @Test
  public void xxxTestStream() {
    //        List<String> asList = Collections.unmodifiableList( Arrays.asList( "a", "b", "c" ));
    List<String> asList = Arrays.asList("a", "b", "c");
    assertThrows(UnsupportedOperationException.class, () -> asList.add("X"));
    assertThrows(UnsupportedOperationException.class, () -> asList.remove(0));
  }

  @Test
  public void shouldBeXXX() {

    // cos a = sin (pi/2-a)
    //        Function<Double, Double> umfang = x -> x * 2 * Math.PI;
    Function<Double, Double> umfang = radius -> 2.0 * Math.PI * radius;
    //        assertThat( umfang.apply( 2.0 ) ).isEqualTo( 12.1444 );
    //Double cos = Function.compose( (Double x) -> Math.PI / 2.0 - x, Math::sin).apply(2.0);
  }

  // https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
  @Test
  void testName() {
    Long summ = 0L;
    for (Integer integer : LIST_OF_INTS) {
      summ += integer;
    }

    Long summS1 = LIST_OF_STRINGS.stream().mapToLong(s -> Integer.valueOf(s)).sum();

    Long summV1 = LIST_OF_INTS.stream().mapToLong(i -> i.longValue()).reduce(0, Long::sum);

    Long summV2 = LIST_OF_INTS.stream().mapToLong(i -> i.longValue()).sum();
    LongSummaryStatistics summV3 = LIST_OF_INTS.stream().mapToLong(i -> i.longValue()).summaryStatistics();

    Long summV4 = LIST_OF_INTS.stream().collect(summingLong(i -> i.longValue()));

    LongAdder la = new LongAdder();
    LIST_OF_INTS.stream().forEach(la::add);
    Long summV5 = la.longValue();
    System.out.println("Summ:" + summV5);

    LongSummaryStatistics collect = LIST_OF_INTS.stream().collect(Collectors.summarizingLong(i -> i.longValue()));
    System.out.println("summarizingLong=" + collect);
    Long summV6 = collect.getSum();


    Double collect2 = LIST_OF_INTS.stream()
      .collect(Collectors.averagingDouble((Integer value) -> Double.valueOf(value)));
    System.out.println("averagingDouble=" + collect2);

    long[] array = LongStream.rangeClosed(1L, 10_000_000L).toArray();
    long count = LongStream.rangeClosed(1L, 10_000_000L).count();
    System.out.println("Count:" + count);

    DoubleAccumulator da;

    List<String> x = new ArrayList<>();
  }

  @Test
  void averagingDouble() {
    List<Double> of = List.of(9_999_999_999_999_999.0d, 1.0d, 3.141_59d, 2.718_28d);
    double forEachResult = 0.0d;
    for (Double value : of) {
      forEachResult += value;
    }

    Double result = of.stream().mapToDouble(Double::valueOf).sum();
    System.out.println("result:" + result);
    System.out.println("forEachResult:" + forEachResult);

    long longFirst = Long.MIN_VALUE;
    long longFirstInverted = -longFirst;
    System.out.println("longFirst: " + longFirst + " longFirstInverted:" + longFirstInverted);

    int first = Integer.MIN_VALUE;
    int firstInverted = -first;
    System.out.println("first: " + first + " firstInverted:" + firstInverted);

    short shortFirst = Short.MIN_VALUE;
    short shortFirstInverted = (short) -shortFirst;

    System.out.println("shortFirst:" + shortFirst + " shortFirstInverted:" + shortFirstInverted);

    byte byteFirst = Byte.MIN_VALUE;
    byte byteFirstInverted = (byte) -byteFirst;
    System.out.println("byteFirst:" + byteFirst + " byteFirstInverted:" + byteFirstInverted);
  }

}
