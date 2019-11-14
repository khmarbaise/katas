package com.soebes.katas.muenzspeicher;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GeldSorteTest {
  @Test
  void notNullCheck() {
    // 100 1 Cent Stücke
    GeldSorte einCent = new GeldSorte(1, 100);
    assertThat(einCent).isNotNull();
  }

  @Test
  void entnehmeGeldAusVorrat() throws NichtGenugVorratException {
    GeldSorte einCent = new GeldSorte(1, 100);
    assertThat(einCent.entnehme()).isEqualTo(1);
  }

  @Test
  void pruefeVorrat() {
    GeldSorte einCent = new GeldSorte(1, 100);
    assertThat(einCent.hasVorrat()).isTrue();
  }

  @Test
  void pruefeEntnahme() throws NichtGenugVorratException {
    GeldSorte einCent = new GeldSorte(1, 1);
    assertThat(einCent.entnehme()).isEqualTo(1);
    assertThat(einCent.hasVorrat()).isFalse();
  }
}
