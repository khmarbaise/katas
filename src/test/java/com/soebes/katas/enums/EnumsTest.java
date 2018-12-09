package com.soebes.katas.enums;

import java.util.EnumSet;

import org.junit.jupiter.api.Test;

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
}
