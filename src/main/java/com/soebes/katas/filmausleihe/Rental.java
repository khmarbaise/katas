package com.soebes.katas.filmausleihe;

public class Rental {

    private Movie movie;
    private int numberOfDaysRented;

    public Rental(Movie movie, int numberOfDaysRented) {
        this.movie = movie;
        this.numberOfDaysRented = numberOfDaysRented;
    }

    public double getPrice() {
        return movie.getPriceType().calculatePrice(numberOfDaysRented);
    }
    
}
