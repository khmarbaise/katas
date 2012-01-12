package com.soebes.katas.kontoverwaltung;

public class Kontoverwaltung {

	/*
	 * Aufgabe:

Für diese Aufgabe soll ein Kontenverwaltungssystem umgesetzt werden:

Ein Konto hat einen Besitzer, einen Kontostand und eine Kontonummer. 
Zusätzlich gibt es eine für alle Konten gültige Zinsrate für Überziehungszinsen. 
Ein Konto kann eröffnet werden. Daneben kann auf ein Konto eingezahlt oder 
abgehoben werden. 

Ferner kann ein positiver Betrag von einem Konto auf ein anderes überwiesen
werden. 
Schließlich besteht die Möglichkeit, sich für ein Konto den Kontostand und die Kontonummer,
sowie die beim derzeitigen Kontostand anfallenden Überziehungszinsen angeben zu lassen. 

Die folgenden Dinge nochmal überdenken:

Setzen Sie die folgenden Methoden um:
-Konstruktoren: Ein Konstruktor initialisiert ein Konto mit den Parametern Kontonummer und Besitzer.
Ein zweiter Konstruktor erhält zusätzlich auch ein Anfangsguthaben als Parameter.

-boolean is InDebit()
Methode zur Abfrage ob ein Konto im Soll ist;

-void withdraw(double balance)
Methode zum Abheben eines Geldbetrages balance;

-void deposit(double balance)
methode zum Einzahlen eines Geldbetrages balance;

-void transfer(double amount, Account recipient)
Methode zum Überweisen eines positiven Geldbetrags amount auf ein Konto recipient,
die Überweisung eines negativen Geldbetrages soll dabei ausgeschlossen werden;

-static String provideAccountInformation(Account account)
Methode zur Ausgabe der Kontoinformationen(Kontonummer/-stand) in einer Zeichenkette.
Im Fall eines negativen Guthabens soll die Zeichenkette auch die anfallenden Überziehungszinsen enthalten.

	 */
}
