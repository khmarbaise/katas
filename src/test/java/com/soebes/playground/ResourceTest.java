package com.soebes.playground;

import org.junit.jupiter.api.Test;

public class ResourceTest {

  @Test
  void firstTest() {
    Resource.use(resource -> {
      resource.operation1();
      resource.operation2();
    });
  }
}
