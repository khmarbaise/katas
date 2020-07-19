package com.soebes.fraction;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BruchTest {

  @Nested
  class UngueltigeWerte {
    @Test
    void nenner_muss_ungleich_null_sein() {
      assertThatIllegalArgumentException().isThrownBy(() -> new Bruch(1, 0)).withMessage("nenner darf nicht 0 sein.");
    }
  }

  @Nested
  class Normalisieren {

    @Test
    void normalisiere_unechten_bruch() {
      Bruch unechterBruch = new Bruch(4, 6);
      assertThat(unechterBruch.getZaehler()).isEqualTo(2);
      assertThat(unechterBruch.getNenner()).isEqualTo(3);
    }
  }

  @Nested
  class Multiplikation {

    @Test
    void multiplikation() {
      Bruch multiplikator = new Bruch(2, 3);
      Bruch multiplikand = new Bruch(4, 5);
      Bruch produkt = multiplikator.multipliziere(multiplikand);
      assertThat(produkt).isEqualTo(new Bruch(8, 15));
    }
  }

  @Nested
  class Addition {
    @Test
    void chaining() {
      Bruch summand_1 = new Bruch(1, 2);
      Bruch summand_2 = new Bruch(1, 3);
      Bruch summand_3 = new Bruch(1, 4);
      Bruch summe = summand_1.addiere(summand_2).addiere(summand_3);
      assertThat(summe).isEqualTo(new Bruch(26, 24));
    }

    @Test
    void add() {
      Bruch summand_1 = new Bruch(2, 3);
      Bruch summand_2 = new Bruch(1, 5);
      Bruch summe = summand_1.addiere(summand_2);
      assertThat(summe).isEqualTo(new Bruch(13, 15));
    }

    @Test
    void add_1_3_plus_2_3_should_be_1_1() {
      Bruch summand_1 = new Bruch(1, 3);
      Bruch summand_2 = new Bruch(2, 3);
      Bruch summe = summand_1.addiere(summand_2);
      assertThat(summe).isEqualTo(new Bruch(3, 3));
    }

  }


}
