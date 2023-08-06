package com.kzibert.monobank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MonoRate {

    @JsonProperty("currencyCodeA")
    private Integer currencyCodeA;
    @JsonProperty("currencyCodeB")
    private Integer currencyCodeB;
    @JsonProperty("date")
    private Long date;
    @JsonProperty("rateBuy")
    private Double rateBuy;
    @JsonProperty("rateCross")
    private Double rateCross;
    @JsonProperty("rateSell")
    private Double rateSell;

    public Integer getCurrencyCodeA() {
        return currencyCodeA;
    }

    public MonoRate setCurrencyCodeA(Integer currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
        return this;
    }

    public Integer getCurrencyCodeB() {
        return currencyCodeB;
    }

    public MonoRate setCurrencyCodeB(Integer currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
        return this;
    }

    public Long getDate() {
        return date;
    }

    public MonoRate setDate(Long date) {
        this.date = date;
        return this;
    }

    public Double getRateBuy() {
        return rateBuy;
    }

    public MonoRate setRateBuy(Double rateBuy) {
        this.rateBuy = rateBuy;
        return this;
    }

    public Double getRateCross() {
        return rateCross;
    }

    public MonoRate setRateCross(Double rateCross) {
        this.rateCross = rateCross;
        return this;
    }

    public Double getRateSell() {
        return rateSell;
    }

    public MonoRate setRateSell(Double rateSell) {
        this.rateSell = rateSell;
        return this;
    }

    @Override
    public String toString() {
        return "MonoRate{" +
                "currencyCodeA='" + currencyCodeA + '\'' +
                ", currencyCodeB='" + currencyCodeB + '\'' +
                ", date=" + date +
                ", rateBuy=" + rateBuy +
                ", rateCross=" + rateCross +
                ", rateSell=" + rateSell +
                '}';
    }
}
