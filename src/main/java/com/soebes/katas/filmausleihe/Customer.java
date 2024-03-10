package com.soebes.katas.filmausleihe;

import java.util.ArrayList;
import java.util.List;

class Customer {

    private Person person;
    private List<Rental> rentals;

    public Customer() {
        rentals = new ArrayList<>();
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

    public void setAusleihen(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public double calculatePrice() {
        return getRentals().stream().mapToDouble(Rental::getPrice).sum();
    }

}
