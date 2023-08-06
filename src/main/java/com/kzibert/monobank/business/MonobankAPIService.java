package com.kzibert.monobank.business;

import com.kzibert.monobank.dto.MonoRateDTO;
import com.kzibert.monobank.model.MonoRate;
import com.kzibert.monobank.model.MonoRateRequest;
import com.kzibert.monobank.util.MonoCurrencyUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MonobankAPIService implements MonobankAPI {

    private final MonoProcessor monoProcessor;
    private final MonoRateConverter monoRateConverter;

    public MonobankAPIService(MonoProcessor monoProcessor, MonoRateConverter monoRateConverter) {
        this.monoProcessor = monoProcessor;
        this.monoRateConverter = monoRateConverter;
    }

    @Override
    public List<MonoRateDTO> getAllMonoRates() {
        return monoProcessor.getAllMonoRates()
                .stream()
                .map(monoRateConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<MonoRateDTO> getAllSupportedMonoRates() {
        return monoProcessor.getAllMonoRates()
                .stream()
                .filter(rate -> MonoCurrencyUtils.getCurrencies().containsValue(rate.getCurrencyCodeA()))
                .map(monoRateConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public MonoRateDTO getMonoRate(MonoRateRequest request) {
        return monoProcessor.getAllMonoRates()
                .stream()
                .filter(monoRate -> isNeededRate(monoRate, request))
                .findFirst()
                .map(monoRateConverter::convert)
                .orElseThrow();
    }

    private boolean isNeededRate(MonoRate monoRate, MonoRateRequest request) {
        return Objects.equals(monoRate.getCurrencyCodeA(), resolveCurrency(request.getCurrencyA()))
                && Objects.equals(monoRate.getCurrencyCodeB(), resolveCurrency(request.getCurrencyB()));
    }

    private Integer resolveCurrency(String currency) {
        return MonoCurrencyUtils.getCurrencyCode(currency);
    }
}
