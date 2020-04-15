package com.solver.sudoku.controller;

import com.solver.sudoku.dto.SudokuBoardDto;
import com.solver.sudoku.mapper.SudokuBoardMapper;
import com.solver.sudoku.service.SudokuBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SudokuBoardController {
    private final SudokuBoardService sudokuBoardService;
    private final SudokuBoardMapper sudokuBoardMapper;

    @GetMapping(value = "/sudoku/{input}")
    public SudokuBoardDto getSolvedSudokuBoard(@PathVariable String input) throws CloneNotSupportedException {
        return sudokuBoardMapper.mapToSuodkuBoardDto(sudokuBoardService.getSudokuBoard(input));
    }
}