package com.soebes.katas.muenzspeicher;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class GeldSorteTest {
    @Test
    public void notNullCheck() {
        //100 1 Cent Stücke
        GeldSorte einCent = new GeldSorte(1, 100);
        assertThat(einCent).isNotNull();
    }

    @Test
    public void entnehmeGeldAusVorrat() throws NichtGenugVorratException {
        GeldSorte einCent = new GeldSorte(1, 100);
        assertThat(einCent.entnehme()).isEqualTo(1);
    }

    @Test
    public void pruefeVorrat() {
        GeldSorte einCent = new GeldSorte(1, 100);
        assertThat(einCent.hasVorrat()).isTrue();
    }

    @Test
    public void pruefeEntnahme() throws NichtGenugVorratException {
        GeldSorte einCent = new GeldSorte(1, 1);
        assertThat(einCent.entnehme()).isEqualTo(1);
        assertThat(einCent.hasVorrat()).isFalse();
    }
}
