package com.soebes.katas.filmausleihe;

public class FamilyPrice implements PriceType {

	/* (non-Javadoc)
	 * @see com.soebes.katas.filmausleihe.PriceType#getPrice(int)
	 */
	@Override
	public double calculatePrice(int numberOfDaysRented) {
        return 0.50 * numberOfDaysRented;
	}
	
}
