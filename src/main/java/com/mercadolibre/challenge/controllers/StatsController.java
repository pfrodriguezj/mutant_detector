package com.mercadolibre.challenge.controllers;

import com.mercadolibre.challenge.dto.StatsDto;
import com.mercadolibre.challenge.services.StatsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "Statistics controller")
@RestController
public class StatsController {

    StatsService statsService;

    public StatsController(StatsService statsService){
        this.statsService = statsService;
    }

    @ApiOperation(value="Get statistics about analyzed DNA strings")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @GetMapping("/stats")
    public ResponseEntity<StatsDto> getStats(){
        StatsDto statsDto = statsService.getStats();
        return ResponseEntity.ok().body(statsDto);
    }
}
