package com.soebes.katas.filmausleihe;

import org.fest.assertions.Delta;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FilmeTest {

    
    private static final Delta DELTA = Delta.delta(1E-6);

    //Mehrere unterschiedlicher Filme
    //Unterschiedliche Preise (je nach Typ und Ausleidauer)
    //Unterschiedliche Personen
    //Rechnungsausgabe
    @Test
    public void firstStep() {
        Person person = new Person("Doe", "John");

        //Kunde besteht aus einer Person
        //die Ausleihen tätigt.
        Customer customer = new Customer();
        customer.setPerson(person);

        Movie movie = new Movie("Die Hard");
        Rental rental = new Rental(movie, 1);

        customer.getRentals().add(rental);
        
        double price = customer.getPrice();
        assertThat(price).isEqualTo(1.00, DELTA);

    }

}
