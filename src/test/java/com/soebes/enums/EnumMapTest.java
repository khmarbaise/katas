package com.soebes.enums;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static com.soebes.enums.EnumMapTest.DaysInWeek.Monday;
import static com.soebes.enums.EnumMapTest.DaysInWeek.Tuesday;

class EnumMapTest {

  enum DaysInWeek {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
  }

  @Test
  void first() {
    EnumMap<DaysInWeek, String> s = new EnumMap<>(
        Map.of(
            Monday, "This is the first day of the week.",
            Tuesday, "This is the second day of the week."
        )
    );
  }
}

