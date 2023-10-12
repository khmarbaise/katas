package com.soebes.katas.comp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CheckTest
{

    public int functionA( int a, int b )
    {
        a = 1;
        b = 2;
        return a * b;
    }

    @Test
    void firstTest()
    {
        int result = functionA( 2, 5 );
        assertThat( result ).isEqualTo( 2 );
    }
}
