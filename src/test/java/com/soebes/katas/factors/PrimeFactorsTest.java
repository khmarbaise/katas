package com.soebes.katas.factors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.testng.annotations.Test;

public class PrimeFactorsTest
{
    @Test
    public void shouldBeOne()
    {
        assertThat( PrimeFactors.factorsOf( 1 ) ).isEqualTo( Collections.emptyList() );
    }
}
