package com.soebes.katas.optional;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class FirstOptionalTest {

  Optional<Plonk> createPlonkV1(Foo foo) {
    if (foo instanceof Bar) {
      return Optional.of(Plonk.makePlonkFromBar((Bar) foo));
    }
    return Optional.empty();
  }

  Optional<Plonk> createPlonk(Foo foo) {
    return Optional.ofNullable(foo)
      .filter(Bar.class::isInstance)
      .map(Bar.class::cast)
      .map(Plonk::makePlonkFromBar);
  }

  @Nested
  class CreatePlonkV1 {

    @Test
    void test_create_plonk_v1() {
      Optional<Plonk> plonk = createPlonkV1(null);
      assertThat(plonk).isEmpty();
    }
  }

  @Nested
  class CreatePlonk {

    @Test
    void check_for_null() {
      Optional<Plonk> plonk = createPlonk(null);
      assertThat(plonk).isEmpty();
    }

    @Test
    void first_test() {
      Bar b = new Bar();

      Optional<Plonk> plonk = createPlonk(b);
      assertThat(plonk).hasValue(new Plonk());
    }
  }

  static class Plonk {
    static Plonk makePlonkFromBar(Bar bar) {
      return new Plonk();
    }
  }

}
