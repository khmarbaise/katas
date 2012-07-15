package com.soebes.katas.filmausleihe;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Person person;
    private List<Rental> rentals;

    public Customer() {
        rentals = new ArrayList<Rental>();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setAusleihen(List<Rental> ausleihen) {
        this.rentals = ausleihen;
    }

    public double getPrice() {
        return 0.0;
    }

}
