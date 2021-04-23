package com.mercadolibre.challenge.services;

import com.mercadolibre.challenge.dto.StatsDto;
import com.mercadolibre.challenge.model.entities.History;
import com.mercadolibre.challenge.model.repository.HistoryRepository;
import org.springframework.stereotype.Service;


import java.util.stream.StreamSupport;

@Service
public class StatsServiceImpl implements StatsService{

    HistoryRepository repository;

    public StatsServiceImpl(HistoryRepository repository){
        this.repository = repository;
    }

    public StatsDto getStats() {
        Iterable<History> dnaRecords = repository.findAll();
        Long mutantDna = StreamSupport.stream(dnaRecords.spliterator(), false).filter(h-> h.getIsMutant()).count();
        Long humanDna = StreamSupport.stream(dnaRecords.spliterator(), false).filter(h->!h.getIsMutant()).count();
        Double ratio = humanDna.doubleValue() == 0 ? 1d : mutantDna.doubleValue()/humanDna.doubleValue();

        StatsDto statsDto = StatsDto.builder()
                .countHumanDna(humanDna)
                .countMutantDna(mutantDna)
                .ratio(ratio)
                .build();

        return statsDto;
    }


    public void saveRecord(String[] genome, boolean isMutant) {

        String jointSequences = String.join(",",genome);

        History history = History.builder()
                .dna(jointSequences)
                .isMutant(isMutant)
                .build();
        repository.save(history);
    }


}
