package com.soebes.katas.getraenkeautomat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GetraenkeAutomatTest {

    @Test
    public void testForInitializers() {
        List<String> result = new ArrayList<>() {
            private static final long serialVersionUID = 1;

            {
                add("test");
                add("test");
            }
        };
        
        List<String> resultLL = new LinkedList<>() {
            private static final long serialVersionUID = 1L;

            {
                add("First");
                add("Second");
            }
        };
        for (String item : result) {
            System.out.println("Item: " + item);
            
        }
        for (String item : resultLL) {
            System.out.println("Item:" + item);
        }
    }

    @Test
    public void mockitoFirstTest() {
//	LinkedList<String> mockedList = mock(LinkedList.class);
//	when(mockedList.get(0)).thenReturn("first");
//	when(mockedList.get(1)).thenThrow(new RuntimeException());
//	
//	System.out.println(mockedList.get(0));
//	
//	System.out.println(mockedList.get(1));
//	
//	verify(mockedList);
    }
//    @Test
//    public void firstTest() {
//	//Given:
//	
//	//Getränke Automat
//	//When:
//	//Then:

    
    //        //Getränke Automat
//        // Geld Einwurf mit Münzspeicher (Geldwechsler)
//        // Zustände des Automaten
//        // Ausgabe Getränk...
//        //
//	
//
//    }

/*
 * Getränkeautomat:
 * Aufstellung:
 * 1.  3 Sorten von Getränken (könnten aber auch mehr sein)
 * 
 *   Unterschiedliche Preise für die Getränke
 *   -> A: 0,60 Euro (2 A für 1,10 Euro, 3 A für 1,60 Euro.. ?)
 *   -> B: 1,10 Euro
 *   -> C: 2,50 Euro
 *
 * 2. Geld Behandlung
 *   Bezahlt werden kann Bar (mit Münzen und Scheinen). Eine Rückgabe findet
 *   statt aber lediglich in Münzen (wg. Rechlicher Konsequenzen).
 *   
 *   (Version 2.0: Ausbaustufe mit EC- und Kreditkarte) => Seperate Ergänzung
 *   
 *   Vorgegeben bekommen wird vom Münzsystem:
 *     dass eine Münze mit entsprechenden Wert erkannt wurde (z.B. 1 x 1,00 Euro oder 3 x 0,50 Euro ).
 *     dass ein Schein mit entsprechendem Wert erkannt wurde. (max. 50 Euro? z.B. 2 x 20 Euro Schein )
 *   
 *   Für die Geldrückgabe können wir die Ausgabe einer Münze Auslösen mit einem 
 *   bestimmten Wert (0,01, 0,02, 0,05, 0,10, 0,20, 0,50, 1,00, 2,00) 
 *   
 *   Wir haben von den jeweiligen Münzen bestimmte Vorräte (Sprich eine bestimmte Anzahl: z.B: 20 Stück etc.).
 *   Wenn die Kapazität des Speichers sinkt muss auch die Annahme des Bar-Geldes entsprechend angepasst werden.
 *   z.B. max. 30 Euro im Speicher somit keine Bezahlung mehr mit 50 Euro Schein! (eventuell besser Regeln überlegen!)
 * 
 * 3. Nachdem erkannt wurde, dass genug Geld entsprechend dem Preis eingeworfen wurde,
 *    kann die Ausgabe der Getränke eingeleitet werden.
 *    
 *    Geldrückgabe kann ebenfalls ausgelöst werden, falls der Sollbetrag übererfüllt ist.
 *    
 * 4. Produktsystem
 * 
 *    -> Wird bekommen einen aktuellen Bestand von Getränken gemelden z.B. A (10 Stück), B ...
 *    
 *    -> Wir können die Ausgabe immer nur eines Getränkes auslösen (seriell!)
 *    
 *    -> Wir bekommen vom System eine Rückmeldung über die erfolgreiche Ausgabe eines Getränkes.
 *    
 *    -> Wenn der Bestand auf Null fällt, darf keine Auswahl mehr möglich sein (vom jeweiligen Produkt)
 *    -> Wenn eine Kunde mehr von einem Getränk anfordert als da sind muss das dem Kunden mit geteilt werden
 *       und keine Auswahl stattfinden. (Eventuell V2.0)
 *    
 * 5. Produktauswahlsystem
 * 
 *    -> Stellt zur Auswahl welche Produkte zur Verfügung stehen (Hängt vom aktuellen Bestand ab).
 *       Initial: z.B.: A: 5, B: 10, C: 6
 *       
 *    -> Wir bekommen die Meldung welche Produkte und in welcher Menge ausgewählt wurden.
 *       -> Berechnung des Preises
 *       -> Abrechnung
 *       -> Rückgeld / Freigabe der Produkte
 *
 * 
 * Ablauf:
 * 
 * 1. Anzeige der zur Verfügung stehenden Produkte (Anpassung an den aktuellen Bestand)
 * 2. Auswahl aus den Produkten
 * 3. Ermittlung des Preise
 * 4. Zahlung des Preises
 * 5. Ausgabe der Produkte 
 * 5. Eventuelle Restgeldrückgabe
 * 
 * wieder bei 1 
 */
}
