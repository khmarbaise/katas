package com.soebes.sugar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class XTest {

  @Test
  void name() {
    var a = List.of("A", "B", "C");

    var stringStringMap = Map.of("K1", "V1", "K2", "V2", "K3", "V3");

    var compassMap = Map.of("north", 0.0f, "east", 90.0f);

    assertThat(a).as("Es wurden nicht alle Element").containsExactly("A", "B");
  }
}
