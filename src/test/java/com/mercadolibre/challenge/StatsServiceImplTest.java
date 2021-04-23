package com.mercadolibre.challenge;

import com.mercadolibre.challenge.dto.StatsDto;
import com.mercadolibre.challenge.model.entities.History;
import com.mercadolibre.challenge.model.repository.HistoryRepository;
import com.mercadolibre.challenge.services.StatsServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StatsServiceImplTest {

    @MockBean
    HistoryRepository repository;

    @Autowired
    StatsServiceImpl service;

    @Test
    public void tetGetStats() {

        History h1 = History.builder()
                .dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG")
                .isMutant(true)
                .id(1)
                .build();

        History h2 = History.builder()
                .dna("AAGCAA,CAGTGC,TTATGT,AGAAGG,CACCTA,TCACTG")
                .isMutant(false)
                .id(2)
                .build();

        History h3 = History.builder()
                .dna("ATGCGA,CAGTGC,TTATGT,AGAATG,CCTCTA,TCACTA")
                .isMutant(false)
                .id(3)
                .build();

        Iterable<History> dnaRecords = List.of(h1, h2, h3);

        when(repository.findAll()).thenReturn(dnaRecords);

        StatsDto statsDto = service.getStats();

        Assertions.assertThat(statsDto)
                .hasFieldOrPropertyWithValue("countMutantDna", 1L)
                .hasFieldOrPropertyWithValue("countHumanDna", 2L)
                .hasFieldOrPropertyWithValue("ratio", 0.5);
    }

    @Test
    public void testSaveRecord(){

        String[] mutantGenome = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

        when(repository.save(any())).thenReturn(History.builder().dna(String.join(",",mutantGenome)).isMutant(true).id(1).build());

        service.saveRecord(mutantGenome, true);

        verify(repository).save(any());
    }

}
