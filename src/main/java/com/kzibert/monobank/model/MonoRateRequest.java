package com.kzibert.monobank.model;

public class MonoRateRequest {

    private final String currencyA;
    private final String currencyB;

    public MonoRateRequest(String currencyA, String currencyB) {
        this.currencyA = currencyA;
        this.currencyB = currencyB;
    }

    public static MonoRateRequest of(String currencyA, String currencyB) {
        return new MonoRateRequest(currencyA, currencyB);
    }

    public static MonoRateRequest ofUAH(String currency) {
        return of(currency, "UAH");
    }

    public String getCurrencyA() {
        return currencyA;
    }

    public String getCurrencyB() {
        return currencyB;
    }
}
