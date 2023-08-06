package com.kzibert.monobank.model;

public enum CurrencyType {

    USD("USD"),
    EUR("EUR"),
    GBP("GBP"),
    UAH("UAH"),
    PLN("PLN");

    public final String name;
    CurrencyType(String name) {
        this.name = name;
    }
}
