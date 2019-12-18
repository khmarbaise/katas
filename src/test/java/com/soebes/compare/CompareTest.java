package com.soebes.compare;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.IntStream;

class CompareTest {

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

    @Override
    public String toString() {
      return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]").add("x=" + x).add("y=" + y).toString();
    }
  }

  @Test
  void name() {
    IntStream.of(1, 2, 5, 7, 8, 9, 45, 67, 89, 3, 4, 5, 6)
      .mapToObj(i -> new Point(i%3, i / 3))
      .sorted((o1, o2) -> Double.compare(o1.distance(0, 0), o2.distance(0,0)) )
      .forEach(p -> System.out.println("p = " + p + " dist:" + p.distance(0, 0)));
  }
  @Test
  void name_second() {
    IntStream.of(1, 2, 5, 7, 8, 9, 45, 67, 89, 3, 4, 5, 6)
      .mapToObj(i -> new Point(i % 3, i / 3))
      .sorted(Comparator.comparing(p -> p.distance(0, 0)))
      .forEach(p -> System.out.println("p = " + p + " dist:" + p.distance(0, 0)));
  }

  static <INPUT, RESULT extends Comparable<RESULT>> Comparator<INPUT> comparing(Function<INPUT, RESULT> keyExtractor) {
    return (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
  }
}
