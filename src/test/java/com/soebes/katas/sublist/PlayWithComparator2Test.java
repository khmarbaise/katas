package com.soebes.katas.sublist;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

public class PlayWithComparator2Test {
  Person michael = new Person("Michael", "Jackson", 51);

  Person jarmaine = new Person("Jermaine", "Jackson", 61);

  Person rod = new Person("Rod", "Stewart", 65);

  Person paul = new Person("Paul", "McCartney", 74);

  Person mick = new Person("Mick", "Jagger", 73);

  @Test
  void testName() {
    PersonComparator<Person> comp = PersonComparator.comparing(Person::getLastName)
        .thenComparing(Person::getFirstName)
        .thenComparing(Person::getAge);

    System.out.println("Michael  :" + michael);
    System.out.println("Jarmaine :" + jarmaine);
    System.out.println("Rod     :" + rod);
    System.out.println("Michael <-> rod      : " + comp.compare(michael, rod));
    System.out.println("Michael <-> Jarmaine : " + comp.compare(michael, jarmaine));

    Comparator<Person> personComparator = Comparator.comparing(Person::getLastName)
        .thenComparing(Person::getFirstName)
        .thenComparing(Person::getAge);

  }

  @Test
  void second_test() {
    PComparator<Person> comp = PComparator.comparing(Person::getLastName)
        .thenComparing(Person::getFirstName)
        .thenComparing(Person::getAge);

    System.out.println("Michael  :" + michael);
    System.out.println("Jarmaine :" + jarmaine);
    System.out.println("Rod     :" + rod);
    System.out.println("Michael <-> rod      : " + comp.compare(michael, rod));
    System.out.println("Michael <-> Jarmaine : " + comp.compare(michael, jarmaine));
  }

  @FunctionalInterface
  public interface PComparator<T> {

    static <T, R extends Comparable<? super R>> PComparator<T> comparing(Function<? super T, R> extractor) {
      Objects.requireNonNull(extractor);
      return (p1, p2) -> {
        R u1 = extractor.apply(p1);
        R u2 = extractor.apply(p2);
        return u1.compareTo(u2);
      };
    }

    int compare(T t1, T t2);

    default <R extends Comparable<? super R>> PComparator<T> thenComparing(Function<? super T, R> extractor) {
      Objects.requireNonNull(extractor);
      return (p1, p2) -> {
        int comp = this.compare(p1, p2);

        if (comp == 0) {
          PComparator<T> other = comparing(extractor);
          return other.compare(p1, p2);
        } else {
          return comp;
        }
      };
    }
  }

  @FunctionalInterface
  public interface PersonComparator<T> {
    // PECS =>
    // producer: ? extends T
    // consumer: ? super T
    static <T, R extends Comparable<? super R>> PersonComparator<T> comparing(Function<? super T, R> extractor) {
      Objects.requireNonNull(extractor);
      return (p1, p2) -> {
        R u1 = extractor.apply(p1);
        R u2 = extractor.apply(p2);
        return u1.compareTo(u2);
      };
    }

    int compare(T t1, T t2);

    default <R extends Comparable<? super R>> PersonComparator<T> thenComparing(Function<? super T, R> extractor) {
      Objects.requireNonNull(extractor);
      return (p1, p2) -> {
        int cmp = this.compare(p1, p2);
        if (cmp == 0) {
          PersonComparator<T> other = comparing(extractor);
          return other.compare(p1, p2);
        } else {
          return cmp;
        }
      };
    }

    default PersonComparator<T> reversed() {
      return (T t1, T t2) -> this.compare(t2, t1);
    }

  }
}
