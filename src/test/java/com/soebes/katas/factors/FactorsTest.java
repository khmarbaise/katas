
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
    }

    public List<Integer> factorsOf( final int n )
    {
        List<Integer> result = new ArrayList<>();
        
        int remainder = n;
        
        if ( remainder > 1 )
        {
            while ( remainder % 2 == 0 )
            {
                result.add( 2 );
                remainder /= 2;
            }
            if ( remainder % 3 == 0 )
            {
                result.add( 3 );
            }
            if ( remainder % 5 == 0 )
            {
                result.add( 5 );
            }
        }
        return result;
    }
}
