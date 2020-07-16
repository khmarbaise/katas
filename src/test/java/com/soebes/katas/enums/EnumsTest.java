package com.soebes.katas.enums;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.List;

class EnumsTest {

    enum FirstEnum {
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        H,
        I,
        J,
        K,
        L,
        M,
        N,
        O,
        P,
        Q
    }

    Integer[] type = {
        1,
        2,
        3,
        4,
        5
    };


    List<String > CONSTANT = List.of("1", "2", "3");


    EnumSet<FirstEnum> enumSet = EnumSet.of(FirstEnum.A, FirstEnum.C, FirstEnum.F, FirstEnum.B);

    void xyz(EnumSet<FirstEnum> par) {
        par.forEach(System.out::println);
    }

    @Test
    void testName() {
        EnumSet<FirstEnum> setup = EnumSet.of(FirstEnum.A, FirstEnum.B, FirstEnum.F);
        xyz(setup);

    }


    @Test
    void enumSetOf() {

        EnumSet<FirstEnum> noneOf = EnumSet.noneOf(FirstEnum.class);

        EnumSet<FirstEnum> firstEnums = EnumSet.allOf(FirstEnum.class);

        EnumSet<FirstEnum> e = EnumSet.of(FirstEnum.E, FirstEnum.A);

        EnumSet<FirstEnum> e1 = EnumSet.of(FirstEnum.E);

        boolean contains = firstEnums.containsAll(e);
        System.out.println("contains:" + contains);
        firstEnums.forEach(fe -> System.out.println(" FE:" + fe.name()));

        EnumSet<FirstEnum> c = EnumSet.of(FirstEnum.C);
        System.out.println(" isEmpty:" + noneOf.isEmpty());
        System.out.println(" isEmpty:" + firstEnums.isEmpty());

    }

    @Test
    void memoryTest() {
//        System.out.println("Details:" + VM.current().details());
//        String s = ClassLayout.parseClass(FirstEnum.class).toPrintable();
//        System.out.println("Size FirstEnum:" + s);
//        String s1 = ClassLayout.parseInstance(type).toPrintable();
//        System.out.println("Size Type:" + s1);
//        String s2 = ClassLayout.parseInstance(enumSet).toPrintable();
//        System.out.println("Size EnumSet:" + s2);

        Long longValue = Long.valueOf(200L);
        String longInfos = ClassLayout.parseInstance(longValue).toPrintable();
        System.out.println("Size Long:" + longInfos);

        long longPrimitive = 200L;
        String longPrimitiveInfos = ClassLayout.parseInstance(longPrimitive).toPrintable();
        System.out.println("Size Long primitive:" + longPrimitiveInfos);

        BigDecimal bd = BigDecimal.valueOf(200L);
        String bdInfos = ClassLayout.parseInstance(bd).toPrintable();
        System.out.println("Size BigDecimal:" + bdInfos);

        Double d = Double.valueOf(12.3d);
        String dInfos = ClassLayout.parseInstance(d).toPrintable();
        System.out.println("Size Double:" + dInfos);

    }
    @Test
    void memory_for_constant() {
        String longInfos = ClassLayout.parseInstance(CONSTANT).toPrintable();
        System.out.println("Size Long:" + longInfos);
    }
}
