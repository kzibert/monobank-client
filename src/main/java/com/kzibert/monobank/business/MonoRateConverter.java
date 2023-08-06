package com.kzibert.monobank.business;

import com.kzibert.monobank.dto.MonoRateDTO;
import com.kzibert.monobank.model.MonoRate;
import com.kzibert.monobank.util.MonoCurrencyUtils;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

public class MonoRateConverter implements Converter<MonoRate, MonoRateDTO> {

    @Override
    public MonoRateDTO convert(MonoRate rate) {
        return new MonoRateDTO()
                .setCurrencyA(MonoCurrencyUtils.getCurrencyName(rate.getCurrencyCodeA()))
                .setCurrencyB(MonoCurrencyUtils.getCurrencyName(rate.getCurrencyCodeB()))
                .setDate(LocalDateTime.now()) // introduce the Long to LocalDateTime converter for datetime
                .setRateBuy(rate.getRateBuy())
                .setRateCross(rate.getRateCross())
                .setRateSell(rate.getRateSell());
    }

}
