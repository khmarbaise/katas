package com.soebes.katas.factors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.testng.annotations.Test;

public class PrimeFactorsTest
{
    @Test
    public void primeOfOneIsOne()
    {
        assertThat( PrimeFactors.of( 1 ) ).isEqualTo( Collections.emptyList() );
    }

    @Test
    public void primeOfTwoIsTwo()
    {
        assertThat( PrimeFactors.of( 2 ) ).containsExactly( 2 );
    }

    @Test
    public void primeOfThreeIsThree()
    {
        assertThat( PrimeFactors.of( 3 ) ).containsExactly( 3 );
    }

    @Test
    public void primeOfFoureIsTwoTimesTwo()
    {
        assertThat( PrimeFactors.of( 4 ) ).containsExactly( 2, 2 );
    }

    @Test
    public void primeOfFiveIsFive()
    {
        assertThat( PrimeFactors.of( 5 ) ).containsExactly( 5 );
    }

    @Test
    public void primeOfSixIsTwoTimesThree()
    {
        assertThat( PrimeFactors.of( 6 ) ).containsExactly( 2, 3 );
    }

    @Test
    public void primeOfSevenIsSeven()
    {
        assertThat( PrimeFactors.of( 7 ) ).containsExactly( 7 );
    }

    @Test
    public void primeOfEightIsTwoTimesTwoTimesTwo()
    {
        assertThat( PrimeFactors.of( 8 ) ).containsExactly( 2, 2, 2 );
    }

    @Test
    public void primeOfNineIsThreeTimesThree()
    {
        assertThat( PrimeFactors.of( 9 ) ).containsExactly( 3, 3 );
    }

    @Test
    public void primeOfTenIsTwoTimesFive()
    {
        assertThat( PrimeFactors.of( 10 ) ).containsExactly( 2, 5 );
    }

    @Test
    public void primeOfElevenIsEleven()
    {
        assertThat( PrimeFactors.of( 11 ) ).containsExactly( 11 );
    }

    @Test
    public void primeOfTwelveIsTwoTimesTwoTimesThree()
    {
        assertThat( PrimeFactors.of( 12 ) ).containsExactly( 2, 2, 3 );
    }

    @Test
    public void primeOfTwoTimesTwoTimesThreeTimesThreeIsTwoTwoThreeThree()
    {
        assertThat( PrimeFactors.of( 2 * 2 * 3 * 3 ) ).containsExactly( 2, 2, 3, 3 );
    }

    @Test
    public void primeOf()
    {
        assertThat( PrimeFactors.of( 5 * 5 * 7 * 7 ) ).containsExactly( 5, 5, 7, 7 );
    }

    @Test
    public void primeOfXXX()
    {
        assertThat( PrimeFactors.of( 2 * 3 * 5 * 7 * 11 * 13 ) ).containsExactly( 2, 3, 5, 7, 11, 13 );
    }
    
}
