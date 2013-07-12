package com.soebes.katas.filmausleihe;

public interface PriceType {
	
    /**
     * Get the price which will be charged for the rented 
     * days.
     * @param numberOfDaysRented
     * @return The price based on the rented days.
     */
    double calculatePrice(int numberOfDaysRented);
    
}
