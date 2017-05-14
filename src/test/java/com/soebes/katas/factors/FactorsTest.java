
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
        assertThat( factorsOf( 2 * 2 * 3 * 3 * 5 * 5 ) ).containsExactly( 2, 2, 3, 3, 5, 5 );
    }

    public List<Integer> factorsOf( final int n )
    {
        int remainder = n;
        List<Integer> result = new ArrayList<>();
        if ( n > 1 )
        {
            while ( remainder % 2 == 0 )
            {
                result.add( 2 );
                remainder /= 2;
            }
            while ( remainder % 3 == 0 )
            {
                result.add( 3 );
                remainder /= 3;
            }
            if ( remainder % 5 == 0 )
            {
                result.add( 5 );
            }
            if ( remainder % 7 == 0 )
            {
                result.add( 7 );
            }
            if ( remainder % 11 == 0 )
            {
                result.add( 11 );
            }
            if ( remainder % 13 == 0 )
            {
                result.add( 13 );
            }
        }
        return result;
    }
}
