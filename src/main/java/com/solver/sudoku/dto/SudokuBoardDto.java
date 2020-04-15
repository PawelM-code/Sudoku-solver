package com.solver.sudoku.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SudokuBoardDto {
    private List<SudokuRowDto> sudokuRowDtoList;
}
