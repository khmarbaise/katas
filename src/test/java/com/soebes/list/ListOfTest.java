package com.soebes.list;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListOfTest {

  @Test
  void name() {
    List.of(1).addAll(Collections.singletonList(1));
  }
}
