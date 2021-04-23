package com.mercadolibre.challenge.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenomeServiceImpl implements GenomeService{


    public String[] transposeMatrix(String[] genome){
        String [] transposed = new String[genome.length];
        for(int i = 0; i < genome.length; i++){
            StringBuilder sb = new StringBuilder();
            for(String s:genome){
                sb.append(s.charAt(i));
            }
            transposed[i] = sb.reverse().toString();
        }
        return transposed;
    }

    public String[] getAscendingDiagonalsFromGenome(String[] matrix){

        List<String> diagonals = new ArrayList<>();
        int initialRow = 3;

        int row = initialRow;
        int column = 0;

        StringBuilder diagonal = new StringBuilder();

        //1. First: traverse ascending diagonals until the major diagonal

        while(initialRow < matrix.length){
            diagonal.append(matrix[row].charAt(column));
            row--;
            column++;
            if(row < 0){
                diagonals.add(diagonal.toString());
                diagonal = new StringBuilder();
                initialRow++;
                row = initialRow;
                column = 0;
            }
        }

        //2. Second: traverse ascending diagonals after the major diagonal
        initialRow = matrix.length - 1;
        row = initialRow;
        int initialColumn = 1;
        column = initialColumn;
        while (initialColumn < matrix.length - 3){
            diagonal.append(matrix[row].charAt(column));
            row--;
            column++;
            if(column >= matrix.length){
                diagonals.add(diagonal.toString());
                diagonal = new StringBuilder();
                row = initialRow;
                initialColumn++;
                column = initialColumn;
            }
        }
        return diagonals.toArray(new String[0]);
    }
}
