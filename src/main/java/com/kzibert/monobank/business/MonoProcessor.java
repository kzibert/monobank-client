package com.kzibert.monobank.business;

import com.kzibert.monobank.model.MonoRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MonoProcessor {

    private final Logger log = LoggerFactory.getLogger(MonoProcessor.class);
    private static final String MONO_URI = "https://api.monobank.ua/bank/currency";
    public static final int DELAY_IN_MILLIS = 60000;

    private List<MonoRate> rates = new ArrayList<>();
    private LocalDateTime lastUpdatedAt;

    public List<MonoRate> getAllMonoRates() {
        return rates.isEmpty() || LocalDateTime.now().minusSeconds(60).isAfter(lastUpdatedAt) ? populateMonoRates() : rates;
    }

    private List<MonoRate> populateMonoRates() {
        rates = getRates();
        lastUpdatedAt = LocalDateTime.now();
        return rates;
    }

    private List<MonoRate> getRates() {
        try {
            return Optional.ofNullable(new RestTemplate().getForObject(MONO_URI, MonoRate[].class))
                    .map(List::of)
                    .orElseThrow();
        } catch (HttpClientErrorException.TooManyRequests ex) {
            log.warn("Too many requests exception encountered! Repeating in " + DELAY_IN_MILLIS / 1000 + " seconds.");
            delay();
            return getAllMonoRates();
        }
    }

    private static void delay() {
        try {
            Thread.sleep(DELAY_IN_MILLIS);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
