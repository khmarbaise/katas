package com.soebes.compare;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CompareTest {

  static <INPUT, RESULT extends Comparable<RESULT>> Comparator<INPUT> comparing(Function<INPUT, RESULT> keyExtactor) {
    return (c1, c2) -> keyExtactor.apply(c1).compareTo(keyExtactor.apply(c2));
  }

  @Test
  void starting_stream() {

    String name = "codefx";
    name.codePoints().boxed().forEach(integer -> System.out.println("integer = " + integer));
    Stream.of(name.codePoints()).forEach(intStream -> System.out.println("intStream = " + intStream));

    name.chars().mapToObj(value -> (char)value).forEach(value -> System.out.println("value = " + value));
  }

  @Test
  void with_own_function() {
    IntStream.of(1, 2, 5, 7, 8, 9, 45, 67, 89, 3, 4, 5, 6)
      .mapToObj(i -> new Point(i % 3, i / 3))
      .sorted(comparing(p -> p.distance(0, 0)))
      .forEach(p -> System.out.println("p = " + p + " dist:" + p.distance(0, 0)));
  }

  @Test
  void name() {
    IntStream.of(1, 2, 5, 7, 8, 9, 45, 67, 89, 3, 4, 5, 6)
      .mapToObj(i -> new Point(i % 3, i / 3))
      .sorted((o1, o2) -> Double.compare(o1.distance(0, 0), o2.distance(0, 0)))
      .forEach(p -> System.out.println("p = " + p + " dist:" + p.distance(0, 0)));
  }

  @Test
  void name_second() {
    IntStream.of(1, 2, 5, 7, 8, 9, 45, 67, 89, 3, 4, 5, 6)
      .mapToObj(i -> new Point(i % 3, i / 3))
      .sorted(Comparator.comparing(p -> p.distance(0, 0)))
      .forEach(p -> System.out.println("p = " + p + " dist:" + p.distance(0, 0)));
  }

  @Test
  void name_third() {
    Point origin = new Point(0, 0);
    IntStream.rangeClosed(1, 500)
      .mapToObj(i -> new Point(i % 3, i / 3))
      .sorted(Comparator.comparing(p -> p.distance(origin)))
      .forEach(p -> System.out.println("p = " + p + " dist:" + p.distance(origin)));
  }

  @Test
  void name_forth() {
    Point origin = new Point(0, 0);
    IntStream.rangeClosed(1, 500)
      .mapToObj(i -> new Point(i % 3, i / 3))
      .mapToDouble(p -> p.distance(origin))
      .forEach(p -> System.out.println("dist:" + p));
  }

  public static class Point {
    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public double distance(int x, int y) {
      int deltaX = x - this.x;
      int deltaY = y - this.y;
      return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double distance(Point location) {
      int deltaX = location.getX() - this.x;
      int deltaY = location.getY() - this.y;
      return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]").add("x=" + x).add("y=" + y).toString();
    }
  }
}
