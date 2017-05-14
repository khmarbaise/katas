
package com.soebes.katas.factors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class FactorsTest
{
    @Test
    public void nothing()
    {
        assertThat( factorsOf( 1 ) ).isEqualTo( Collections.emptyList() );
        assertThat( factorsOf( 2 ) ).containsExactly( 2 );
        assertThat( factorsOf( 3 ) ).containsExactly( 3 );
        assertThat( factorsOf( 4 ) ).containsExactly( 2, 2 );
        assertThat( factorsOf( 5 ) ).containsExactly( 5 );
        assertThat( factorsOf( 6 ) ).containsExactly( 2, 3 );
        assertThat( factorsOf( 7 ) ).containsExactly( 7 );
        assertThat( factorsOf( 8 ) ).containsExactly( 2, 2, 2 );
        assertThat( factorsOf( 9 ) ).containsExactly( 3, 3 );
        assertThat( factorsOf( 10 ) ).containsExactly( 2, 5 );
        assertThat( factorsOf( 11 ) ).containsExactly( 11 );
        assertThat( factorsOf( 12 ) ).containsExactly( 2, 2, 3 );
        assertThat( factorsOf( 13 ) ).containsExactly( 13 );
        assertThat( factorsOf( 14 ) ).containsExactly( 2, 7 );
        assertThat( factorsOf( 15 ) ).containsExactly( 3, 5 );
        assertThat( factorsOf( 15 ) ).containsExactly( 3, 5 );
        assertThat( factorsOf( 2 * 2 * 3 * 3 * 5 * 5 ) ).containsExactly( 2, 2, 3, 3, 5, 5 );
        assertThat( factorsOf( 2 * 2 * 3 * 3 * 5 * 5 * 7 ) ).containsExactly( 2, 2, 3, 3, 5, 5, 7 );
        assertThat( factorsOf( 2 * 2 * 3 * 3 * 5 * 5 * 7 * 11 * 11  ) ).containsExactly( 2, 2, 3, 3, 5, 5, 7, 11, 11 );
        assertThat( factorsOf( 2 * 2 * 3 * 3 * 5 * 5 * 7 * 11 * 13 ) ).containsExactly( 2, 2, 3, 3, 5, 5, 7, 11, 13 );
        assertThat( factorsOf( 2 * 2 * 3 * 3 * 5 * 5 * 7 * 11 * 13 * 13 ) ).containsExactly( 2, 2, 3, 3, 5, 5, 7, 11, 13, 13 );
        assertThat( factorsOf( 2 * 2 * 3 * 3 * 5 * 5 * 7 * 11 * 11 * 13 * 13 ) ).containsExactly( 2, 2, 3, 3, 5, 5, 7, 11, 11, 13, 13 );
        assertThat( factorsOf( 2 * 2 * 3 * 3 * 5 * 5 * 7 * 7 * 11 * 11 * 13 * 13 ) ).containsExactly( 2, 2, 3, 3, 5, 5, 7, 7, 11, 11, 13, 13 );
    }

    public List<Integer> factorsOf( final int n )
    {
        List<Integer> result = new ArrayList<>();

        int remainder = n;

        int divider = 2;

        while ( remainder > 1 )
        {
            while ( remainder % divider == 0 )
            {
                result.add( divider );
                remainder /= divider;
            }
            divider++;
        }
        return result;
    }
}
