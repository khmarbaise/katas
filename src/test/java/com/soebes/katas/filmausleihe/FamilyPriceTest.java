package com.soebes.katas.filmausleihe;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FamilyPriceTest extends TestBase {

    @DataProvider(name = "createPriceTestSetForFamilyMovie")
    public Object[][] createPriceTestSetForFamilyMovie() {
        //@formatter:off
        return new Object[][] {
            { 1,  0.50 },
            { 2,  1.00 },
            { 3,  1.50 },
            { 4,  2.00 },
        };
        //@formatter:on
    }

    @Test(dataProvider = "createPriceTestSetForFamilyMovie")
    public void shouldGiveThePriceForRentalOfDifferentDaysForFamilyMovie(int rentedDays, double expectedPrice) {
        PriceType price = new FamilyPrice();
        double result = price.calculatePrice(rentedDays);
        assertThat( result).isEqualTo(expectedPrice, DELTA);
    }

}
