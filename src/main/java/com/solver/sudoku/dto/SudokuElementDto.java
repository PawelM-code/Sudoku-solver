package com.solver.sudoku.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties
public class SudokuElementDto {
    private int value;
    @JsonIgnore
    private List<Integer> listOfAllPossibleElementValues;
}
