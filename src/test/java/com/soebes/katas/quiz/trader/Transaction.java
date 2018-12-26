package com.soebes.katas.quiz.trader;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public Trader getTrader() {
        return this.trader;
    }


}