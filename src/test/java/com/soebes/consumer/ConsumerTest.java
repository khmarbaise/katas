package com.soebes.consumer;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;
import java.util.function.IntConsumer;
import java.util.stream.Collector;
import java.util.stream.IntStream;

class ConsumerTest {
  @Test
  void consumer_first_test() {
    Averager averageCollect = IntStream.range(0, 1000)
        .collect(Averager::new, Averager::accept, Averager::combine);
    System.out.println("averageCollect = " + averageCollect);
  }

  static class Averager implements IntConsumer {
    private int total;
    private int count;

    public Averager() {
      System.out.println("Averager.Averager");
      this.total = 0;
      this.count = 0;
    }

    public double average() {
      System.out.println("Averager.average");
      return count > 0 ? ((double) total) / count : 0;
    }

    public void accept(int i) {
      System.out.println("Averager.accept i=" + i);
      total += i;
      count++;
    }

    public void combine(Averager other) {
      System.out.println("Averager.combine this:" + this + " other:" + other);
      total += other.total;
      count += other.count;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Averager.class.getSimpleName() + "[", "]")
          .add("total=" + total)
          .add("count=" + count)
          .toString();
    }
  }
}
