
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
    }

    public List<Integer> factorsOf( final int n )
    {
        List<Integer> result = new ArrayList<>();
        if ( n > 1 )
        {
            result.add( 2 );
        }
        return result;
    }
}
