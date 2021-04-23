package com.mercadolibre.challenge.services;

import java.util.function.Predicate;
import java.util.regex.Matcher;

import static com.mercadolibre.challenge.Constants.COMPILED_MUTANT_PATTERN;

public interface GenomeService {

    Predicate<String> segmentHasMutantDna = (s)->{
        Matcher matcher = COMPILED_MUTANT_PATTERN.matcher(s);
        return matcher.find();
    };

    String[] transposeMatrix(String[] genome);
    String[] getAscendingDiagonalsFromGenome(String[] matrix);
}
