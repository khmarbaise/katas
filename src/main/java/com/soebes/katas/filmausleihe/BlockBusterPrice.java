package com.soebes.katas.filmausleihe;

public class BlockBusterPrice implements PriceType {

	/* (non-Javadoc)
	 * @see com.soebes.katas.filmausleihe.PriceType#getPrice(int)
	 */
	@Override
	public double calculatePrice(int numberOfDaysRented) {
		//First Day 3.00
		//Second Day 2.00
		//Third Day 1.00
		//4.- 0.75
		
		double result = 3.00;
		if (numberOfDaysRented > 1) {
			result += 2.00;
		}
		if (numberOfDaysRented > 2) {
			result += 1.00;
		}
		if (numberOfDaysRented > 3) {
			result += 0.75 * (numberOfDaysRented - 3);
		}
        return result;
	}
	
}
