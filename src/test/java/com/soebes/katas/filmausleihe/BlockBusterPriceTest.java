package com.soebes.katas.filmausleihe;

import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BlockBusterPriceTest extends TestBase {

    @DataProvider(name = "createPriceTestSetForBlockBusterMovie")
    public Object[][] createPriceTestSetForBlockBusterMovie() {
        return new Object[][] {
            { 1,  3.00 },
            { 2,  5.00 },
            { 3,  6.00 },
            { 4,  6.75 },
            { 5,  7.50 },
            { 6,  8.25 },
        };
    }

    @Test(dataProvider = "createPriceTestSetForBlockBusterMovie")
    public void shouldGiveThePriceForRentalOfDifferentDaysOfABlockBusterMovie(int rentendDays, double expectedPrice) {
        PriceType price = new BlockBusterPrice();
        double result = price.calculatePrice(rentendDays);
        assertThat(result).isEqualTo(expectedPrice, DELTA);
    }

}
