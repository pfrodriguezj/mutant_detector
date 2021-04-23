package com.mercadolibre.challenge.services;


import com.mercadolibre.challenge.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MutantDetectorServiceImpl implements MutantDetectorService{

    GenomeService genomeService;

    public MutantDetectorServiceImpl(GenomeService genomeService){
        this.genomeService = genomeService;
    }

    public boolean isMutant(final String [] genome){
        //1. Get the transposed matrix
        String[] transposed = genomeService.transposeMatrix(genome);
        //2. Get ascending diagonal
        String[] ascendingDiagonals = genomeService.getAscendingDiagonalsFromGenome(genome);
        //3. Get descending diagonal
        String[] descendingDiagonals = genomeService.getAscendingDiagonalsFromGenome(transposed);

        //4. Merge all arrays in one
        List<String> merged = Stream.of(genome, transposed, ascendingDiagonals, descendingDiagonals).flatMap(Stream::of).collect(Collectors.toList());

        //5. Filter, limiting to MIN_COMPLIANT_SEQUENCES
        Long compliantSequences = merged.stream().filter(s -> GenomeService.segmentHasMutantDna.test(s)).limit(Constants.MIN_COMPLIANT_SEQUENCES).count();

        if(compliantSequences < Constants.MIN_COMPLIANT_SEQUENCES){
            return false;
        }
        return true;
    }


}
