package com.mercadolibre.challenge.controllers;

import com.mercadolibre.challenge.dto.GenomeListRequest;
import com.mercadolibre.challenge.services.MutantDetectorService;
import com.mercadolibre.challenge.services.StatsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;

@Api(value = "MutantController")
@RestController
@Validated
@Slf4j
public class MutantController {

    MutantDetectorService detectorService;
    StatsService statsService;

    public MutantController(MutantDetectorService detectorService,
                            StatsService statsService){
        this.detectorService = detectorService;
        this.statsService = statsService;
    }

    @ApiOperation(value="Analyze a dna in order to know if it is mutant or it isn't")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "DNA is mutant, Magneto welcomes you to his almighty team"),
            @ApiResponse(code = 403, message = "DNA is human, Magneto will master over you"),
            @ApiResponse(code = 400, message = "Invalid DNA String. You must be an alien")
    })
    @PostMapping("/mutant")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> postIsMutant(@RequestBody @Valid GenomeListRequest genomeListRequest){

        log.info("Entrando a postIsMutant");
        String [] dna = Arrays.stream(genomeListRequest.getDna()).map(d->d.getDna()).toArray(String[]::new);
        log.info("DNA recibido: " + dna, dna);
        Boolean isMutant = detectorService.isMutant(dna);
        log.info("Is mutant: " + isMutant);

        statsService.saveRecord(dna, isMutant);
        log.info("Saved record");

        HttpStatus status = isMutant ? HttpStatus.OK : HttpStatus.FORBIDDEN;

        return ResponseEntity.status(status).build();
    }
}
