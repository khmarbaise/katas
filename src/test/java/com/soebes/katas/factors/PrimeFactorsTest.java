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
    public void primeOfFourIsTwoTimesTwo()
    {
        assertThat( PrimeFactors.factorsOf( 4 ) ).containsExactly( 2, 2 );
    }

    @Test
    public void primeOfFiveIsFive()
    {
        assertThat( PrimeFactors.factorsOf( 5 ) ).containsExactly( 5 );
    }

    @Test
    public void primeOfSixIsTwoTimesThree()
    {
        assertThat( PrimeFactors.factorsOf( 6 ) ).containsExactly( 2, 3 );
    }

    @Test
    public void primeOfSevenIsSeven()
    {
        assertThat( PrimeFactors.factorsOf( 7 ) ).containsExactly( 7 );
    }

    @Test
    public void primeOfEightIsTwoTimeTwoTimesTwo()
    {
        assertThat( PrimeFactors.factorsOf( 8 ) ).containsExactly( 2, 2, 2 );
    }

}
