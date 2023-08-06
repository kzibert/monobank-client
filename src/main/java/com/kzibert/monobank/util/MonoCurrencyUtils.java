package com.kzibert.monobank.util;

import com.kzibert.monobank.model.CurrencyType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MonoCurrencyUtils {

    public static Map<String, Integer> currencies;

    // ISO 4217

    //// TODO: 6/10/2023 move supported currencies list to db
    static {
        currencies = new HashMap<>();
        currencies.put(CurrencyType.USD.name, 840);
        currencies.put(CurrencyType.EUR.name, 978);
        currencies.put(CurrencyType.GBP.name, 826);
        currencies.put(CurrencyType.UAH.name, 980);
        currencies.put(CurrencyType.PLN.name, 985);
    }

    public static Map<String, Integer> getCurrencies() {
        return currencies;
    }

    public static Integer getCurrencyCode(String currencyName) {
        return currencies.get(currencyName);
    }

    public static String getCurrencyName(Integer currencyCode) {
        return currencies.entrySet()
                .stream()
                .filter(currency -> Objects.equals(currency.getValue(), currencyCode))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow();
    }
}
