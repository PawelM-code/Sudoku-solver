package com.solver.sudoku.mapper;

import com.solver.sudoku.domain.SudokuRow;
import com.solver.sudoku.dto.SudokuElementDto;
import com.solver.sudoku.dto.SudokuRowDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SudokuRowMapper {

    SudokuRowDto mapToSudokuRowDto(SudokuRow sudokuRow) {
        return new SudokuRowDto(sudokuRow.getSudokuElements()
                .stream()
                .map(sudokuElement -> new SudokuElementDto(
                        sudokuElement.getValue(),
                        sudokuElement.getListOfAllPossibleElementValues())
                ).collect(Collectors.toList()));
    }
}
