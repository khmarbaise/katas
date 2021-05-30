package com.soebes.arraylist;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ArrayListTest {

  @Test
  void resize_test() {
    ArrayList<String> elements = new ArrayList<>(0);

    elements.add("AAAA");

    System.out.println("elements = " + elements);
  }
}
