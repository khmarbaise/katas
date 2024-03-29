package com.soebes.katas.comp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FirstComparatorTest
{

    @Test
    void firstTest()
    {
        FirstCompXXXX x = new FirstCompXXXX();
        String o1 = "A";
        String o2 = "B";
        int compare = x.compare( o1, o2 );
        assertThat( compare ).isEqualTo( -1 );
        int compareVS = x.compare( o2, o1 );
        assertThat( compareVS ).isEqualTo( +1 );
    }
}
