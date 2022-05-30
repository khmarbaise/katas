package com.soebes.types;

import org.junit.jupiter.api.Test;

class SetTest {

  record X(int x, int y) { }

  @Test
  void name() {
    X[] xx = {new X(1, 2), new X(2, 3)};
  }
}
