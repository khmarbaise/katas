package com.soebes.katas.filmausleihe;

public class Movie {

    private String title;

    public Movie(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice(int numberOfDaysRented) {
        return 1.00 * numberOfDaysRented;
    }
    
}
