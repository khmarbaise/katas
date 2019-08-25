package com.soebes.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class FirstListTest {

  List<String> reverseList(List<String> orderList) {
    return List.of();
  }

  private List<String> originalList;

  @BeforeEach
  void beforeEach() {
    this.originalList = new LinkedList<>();
    originalList.add("First");
    originalList.add("Second");
    originalList.add("Third");
  }

  @Test
  void first() {
    System.out.println("a = " + originalList);
  }
}
