package com.mercadolibre.challenge.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StatsDto {
    private Long countMutantDna;
    private Long countHumanDna;
    private Double ratio;
}
