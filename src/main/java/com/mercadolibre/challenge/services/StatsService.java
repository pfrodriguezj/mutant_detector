package com.mercadolibre.challenge.services;

import com.mercadolibre.challenge.dto.StatsDto;

public interface StatsService {
    StatsDto getStats();
    void saveRecord(String[] genome, boolean isMutant);
}
