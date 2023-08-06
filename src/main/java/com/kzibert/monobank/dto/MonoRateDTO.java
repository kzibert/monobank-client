package com.kzibert.monobank.dto;

import java.time.LocalDateTime;

public class MonoRateDTO {

    private String currencyA;
    private String currencyB;
    private LocalDateTime date;
    private Double rateBuy;
    private Double rateCross;
    private Double rateSell;

    public String getCurrencyA() {
        return currencyA;
    }

    public MonoRateDTO setCurrencyA(String currencyA) {
        this.currencyA = currencyA;
        return this;
    }

    public String getCurrencyB() {
        return currencyB;
    }

    public MonoRateDTO setCurrencyB(String currencyB) {
        this.currencyB = currencyB;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public MonoRateDTO setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Double getRateBuy() {
        return rateBuy;
    }

    public MonoRateDTO setRateBuy(Double rateBuy) {
        this.rateBuy = rateBuy;
        return this;
    }

    public Double getRateCross() {
        return rateCross;
    }

    public MonoRateDTO setRateCross(Double rateCross) {
        this.rateCross = rateCross;
        return this;
    }

    public Double getRateSell() {
        return rateSell;
    }

    public MonoRateDTO setRateSell(Double rateSell) {
        this.rateSell = rateSell;
        return this;
    }
}
