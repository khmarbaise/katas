package com.soebes.katas.functional;

@FunctionalInterface
public interface Function2<T, U, V> {
  V apply(T t, U u);

  default void count() {
    // increment counter
  }
}