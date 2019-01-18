package com.soebes.katas.enums;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

class EnumsTest
{

    enum FirstEnum {
        A,
        B,
        C,
        D,
        E,
        F
    }
    
    void xyz (EnumSet<FirstEnum> par) {
        par.forEach( System.out::println );
    }

    @Test
    void testName()
    {
        EnumSet<FirstEnum> setup = EnumSet.of( FirstEnum.A, FirstEnum.B, FirstEnum.F );
        xyz(setup);
        
    }

    @Test
    void enumSetOf() {

        EnumSet<FirstEnum> noneOf = EnumSet.noneOf( FirstEnum.class );

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
}
