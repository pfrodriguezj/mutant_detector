package com.mercadolibre.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class DnaSequence {
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[CAGTcagt]+$", message = "There are not allowed characters in dna string")
    String dna;
}
