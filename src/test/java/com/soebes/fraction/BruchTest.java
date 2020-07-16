package com.soebes.fraction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BruchTest {

  @Test
  void add_1_3_plus_2_3_should_be_1_1() {
    Bruch summand_1 = new Bruch(1, 3);
    Bruch summand_2 = new Bruch(2, 3);
    Bruch summe = summand_1.add(summand_2);
    assertThat(summe).isEqualTo(new Bruch(3,3));
  }

  @Test
  void add() {
    Bruch summand_1 = new Bruch(2, 3);
    Bruch summand_2 = new Bruch(1, 5);
    Bruch summe = summand_1.add(summand_2);
    assertThat(summe).isEqualTo(new Bruch(13,15));
  }
}
