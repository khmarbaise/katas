package com.soebes.katas.enums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

import static com.soebes.katas.enums.EnumSecondTest.KonnektorAttribut.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EnumSecondTest {
    public enum KonnektorAttribut {
        Bremsweg,
        DistanzErstesVorsignal,
        DistanzLetztesVorsignal,
        DistanzErstesHauptsignal,
        DistanzLetztesHauptsignal,
        Neigung,
        Tunnel,
        Bogen,
        LinienZugBeeinflussung
    }

    EnumSet<KonnektorAttribut> AttributeDesKonnektors = EnumSet.noneOf(KonnektorAttribut.class);

    public boolean konntektorHat(EnumSet<KonnektorAttribut> para) {
        return AttributeDesKonnektors.contains(para);
    }
    public boolean konntektorHat(KonnektorAttribut para) {
        return AttributeDesKonnektors.contains(para);
    }
    public boolean konntektorHatKein(KonnektorAttribut para) {
        return !AttributeDesKonnektors.contains(para);
    }

    public boolean konntektorHatKein(KonnektorAttribut para1, KonnektorAttribut para2) {
        return !AttributeDesKonnektors.containsAll(Arrays.asList(para1, para2));
    }

    @Test
    void firstTest() {

        AttributeDesKonnektors.add(Bremsweg);
        AttributeDesKonnektors.add(DistanzLetztesHauptsignal);


        assertThat(konntektorHat(Bogen)).isFalse();
        assertThat(konntektorHat(Bremsweg)).isTrue();
        assertThat(konntektorHatKein(Bremsweg)).isFalse();

        assertThat(konntektorHatKein(DistanzErstesVorsignal, DistanzLetztesVorsignal)).isTrue();

    }


    @Test
    void secondTest() {
        /**
         * 0-Bremsweg 1-DistanzErstesVorsignal 2-DistanzLetztesVorsignal 3-DistanzErstesHauptsignal
         * 4-DistanzLetztesHauptsignal 5-Neigung 6-Tunnel 7-Bogen 8-LZB
         * !(found[1] && found[2])
         */
    }
}
