package com.mercadolibre.challenge;

import com.mercadolibre.challenge.services.MutantDetectorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MutantDetectorServiceImplTest {

    @Autowired
    MutantDetectorServiceImpl service;

    @Test
    public void testIsMutant() {
        String[] mutantGenome = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

        boolean isMutant = service.isMutant(mutantGenome);

        Assertions.assertTrue(isMutant);
    }

    @Test
    public void testIsNotMutant() {
        String[] mutantGenome = {"ATGCGA", "CAGTTC", "TTATGT", "AGAAGG", "CCTCTA", "TCACTG"};
        boolean isMutant = service.isMutant(mutantGenome);
        Assertions.assertTrue(!isMutant);
    }


}
