package com.soebes.katas.filmausleihe;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FamilyPriceTest
    extends TestBase
{

    static Stream<Arguments> createPriceTestSetForFamilyMovie()
    {
        // @formatter:off
        return Stream.of( //
          Arguments.of( 1, 0.50 ), //
          Arguments.of( 2, 1.00 ), //
          Arguments.of( 3, 1.50 ), //
          Arguments.of( 4, 2.00 ) //
        );
        // @formatter:on
    }

    @ParameterizedTest
    @MethodSource( "createPriceTestSetForFamilyMovie" )
    public void shouldGiveThePriceForRentalOfDifferentDaysForFamilyMovie( int rentedDays, double expectedPrice )
    {
        PriceType price = new FamilyPrice();
        double result = price.calculatePrice( rentedDays );
        assertThat( result ).isEqualTo( expectedPrice, DELTA );
    }

}
