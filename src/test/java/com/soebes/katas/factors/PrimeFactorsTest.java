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
    public void primeOfEightIsTwoTimesTwoTimesTwo()
    {
        assertThat( PrimeFactors.factorsOf( 8 ) ).containsExactly( 2, 2, 2 );
    }

    @Test
    public void primeOfNineIsThreeTimesThree()
    {
        assertThat( PrimeFactors.factorsOf( 9 ) ).containsExactly( 3, 3 );
    }

    @Test
    public void primeOfTenIsTwoTimesFive()
    {
        assertThat( PrimeFactors.factorsOf( 10 ) ).containsExactly( 2, 5 );
    }

    @Test
    public void primeOfElevenIsEleven()
    {
        assertThat( PrimeFactors.factorsOf( 11 ) ).containsExactly( 11 );
    }

    @Test
    public void primeOfTwelveIsTwoTimesTwoTimesThree()
    {
        assertThat( PrimeFactors.factorsOf( 12 ) ).containsExactly( 2, 2, 3 );
    }
}
