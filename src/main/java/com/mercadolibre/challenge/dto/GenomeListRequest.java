package com.mercadolibre.challenge.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenomeListRequest {
    //private List<@Valid @NotBlank @Pattern(regexp = "^[CAGTcagt]+$") DnaSequence> dna;
    //private List<@Valid DnaSequence> dna;
    private @Valid DnaSequence[] dna;
}
