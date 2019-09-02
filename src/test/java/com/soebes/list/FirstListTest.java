package com.soebes.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class FirstListTest {

  List<String> reverseList(List<String> orderList) {
    List<String> resultList = new LinkedList<>(orderList);
    Collections.reverse(resultList);
    return resultList;
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
    List<String> reverseList = reverseList(originalList);
    System.out.println("reverseList = " + reverseList);
  }
}
