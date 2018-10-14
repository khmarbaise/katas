package com.soebes.katas.filmausleihe;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BlockBusterPriceTest
    extends TestBase
{
    static Stream<Arguments> createPriceTestSetForBlockBusterMovie()
    {
        //@formatter:off
        return Stream.of(
              Arguments.of( 1, 3.00),
              Arguments.of(2, 5.00),
              Arguments.of(3, 6.00),
              Arguments.of(4, 6.75),
              Arguments.of(5, 7.50),
              Arguments.of(6, 8.25)
        );
        //@formatter:on
    }

    @ParameterizedTest
    @MethodSource("createPriceTestSetForBlockBusterMovie")
    public void shouldGiveThePriceForRentalOfDifferentDaysOfABlockBusterMovie( int rentendDays, double expectedPrice )
    {
        PriceType price = new BlockBusterPrice();
        double result = price.calculatePrice( rentendDays );
        assertThat( result ).isEqualTo( expectedPrice, DELTA );
    }

}
