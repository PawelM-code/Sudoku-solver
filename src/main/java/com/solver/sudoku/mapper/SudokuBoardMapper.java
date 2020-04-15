package com.solver.sudoku.mapper;

import com.solver.sudoku.domain.SudokuBoard;
import com.solver.sudoku.dto.SudokuBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SudokuBoardMapper {
    private final SudokuRowMapper sudokuRowMapper;

    public SudokuBoardDto mapToSuodkuBoardDto(SudokuBoard sudokuBoard) {
        return new SudokuBoardDto(sudokuBoard.getSudokuBoard()
                .stream()
                .map(sudokuRowMapper::mapToSudokuRowDto)
                .collect(Collectors.toList())
        );
    }
}
