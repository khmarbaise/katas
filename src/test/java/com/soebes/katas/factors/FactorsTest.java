
package com.soebes.katas.factors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class FactorsTest
{
    @Test
    public void nothing()
    {
        assertThat( factorsOf( 1 ) ).isEqualTo( Collections.emptyList() );
    }

    public List<Integer> factorsOf( final int n )
    {
        return Collections.emptyList();
    }
}
