package com.mercadolibre.challenge;

import com.mercadolibre.challenge.services.GenomeServiceImpl;
import org.assertj.core.api.Condition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class GenomeServiceImplTest {

    @Autowired
    GenomeServiceImpl service;

    @Test
    public void testRegexMatching(){

        Pattern p = Pattern.compile("^[ACGTacgt]");
        Matcher m = p.matcher("ACACAG");

        boolean isMatch = GenomeServiceImpl.segmentHasMutantDna.test("acgtttta");
        boolean isNotMatch = GenomeServiceImpl.segmentHasMutantDna.test("acgtttc");

        Assert.isTrue(isMatch, "evaluated string matches regex");
        Assert.isTrue(!isNotMatch, "evaluated string does not match regex");

        isMatch = GenomeServiceImpl.segmentHasMutantDna.test("ACGTTTTA");
        isNotMatch = GenomeServiceImpl.segmentHasMutantDna.test("ACGTTTC");

        Assert.isTrue(isMatch, "evaluated string matches regex");
        Assert.isTrue(!isNotMatch, "evaluated string does not match regex");

        isMatch = GenomeServiceImpl.segmentHasMutantDna.test("aCgTtTta");
        isNotMatch = GenomeServiceImpl.segmentHasMutantDna.test("AcgTtTc");

        Assert.isTrue(isMatch, "evaluated string matches regex");
        Assert.isTrue(!isNotMatch, "evaluated string does not match regex");
    }

    @Test
    public void testGetDiagonals(){

        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String[] transposed = service.transposeMatrix(dna);
        String[] ascendingDiagonals = service.getAscendingDiagonalsFromGenome(dna);
        String[] descendingDiagonals = service.getAscendingDiagonalsFromGenome(transposed);

        Assertions.assertThat(transposed)
                .hasSize(6)
                .areAtLeastOne(new Condition<>(List.of(transposed)::contains, "GAGTCA"));

        Assertions.assertThat(ascendingDiagonals)
                .hasSize(5)
                .areAtLeastOne(new Condition<>(List.of(ascendingDiagonals)::contains, "TCATGA"));

        Assertions.assertThat(descendingDiagonals)
                .hasSize(5)
                .areAtLeastOne(new Condition<>(List.of(descendingDiagonals)::contains, "AAAATG"));

    }

}
