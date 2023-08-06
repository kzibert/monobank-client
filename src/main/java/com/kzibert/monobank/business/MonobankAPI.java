package com.kzibert.monobank.business;

import com.kzibert.monobank.dto.MonoRateDTO;
import com.kzibert.monobank.model.MonoRateRequest;

import java.util.List;

public interface MonobankAPI {

    List<MonoRateDTO> getAllMonoRates();

    List<MonoRateDTO> getAllSupportedMonoRates();

    MonoRateDTO getMonoRate(MonoRateRequest request);
}
