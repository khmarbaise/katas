package com.soebes.katas.factors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.testng.annotations.Test;

public class PrimeFactorsTest
{
    @Test
    public void primeOfOneIsOne()
    {
        assertThat( PrimeFactors.factorsOf( 1 ) ).isEqualTo( Collections.emptyList() );
    }

    @Test
    public void primeOfTwoIsTwo()
    {
        assertThat( PrimeFactors.factorsOf( 2 ) ).containsExactly( 2 );
    }

    @Test
    public void primeOfThreeIsThree()
    {
        assertThat( PrimeFactors.factorsOf( 3 ) ).containsExactly( 3 );
    }

    @Test
    public void primeOfFoureIsTwoTimesTwo()
    {
        assertThat( PrimeFactors.factorsOf( 4 ) ).containsExactly( 2, 2 );
    }

    @Test
    public void primeOfFiveIsFive()
    {
        assertThat( PrimeFactors.factorsOf( 5 ) ).containsExactly( 5 );
    }
}
