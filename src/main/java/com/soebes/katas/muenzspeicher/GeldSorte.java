package com.soebes.katas.muenzspeicher;


/**
 * Die Klasse GeldSort enthält einen Vorrat von Münzen bzw.
 * Scheinen.
 * Der parameter cent bestimmt wieviel Cent die jeweilige 
 * Geldsorte hat.
 * 
 * 1 ist eine 1 Cent Münze
 * 2 ist eine 2 Cent Münze
 * 5 ist eine 5 Cent Münze
 * 10 ist eine 10 Cent Münze
 * 100 ist eine 1 Euro Münze
 * 1000 ist ein 10-Euro Schein
 * 
 * @author Karl Heinz Marbaise
 *
 */
public class GeldSorte {
    private int cent;
    private int anzahlEnheiten;

    public GeldSorte(int cent, int anzahlEnheiten) {
        super();
        this.cent = cent;
        this.anzahlEnheiten = anzahlEnheiten;
    }

    public int getCent() {
        return cent;
    }

    public void setCent(int cent) {
        this.cent = cent;
    }

    public int getAnzahlEnheiten() {
        return anzahlEnheiten;
    }

    public void setAnzahlEnheiten(int anzahlEnheiten) {
        this.anzahlEnheiten = anzahlEnheiten;
    }

    public boolean hasVorrat() {
        if (anzahlEnheiten > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int entnehme() throws NichtGenugVorratException {
        if (hasVorrat()) {
            anzahlEnheiten--;
            return cent;
        } else {
            throw new NichtGenugVorratException();
        }
    }

}
