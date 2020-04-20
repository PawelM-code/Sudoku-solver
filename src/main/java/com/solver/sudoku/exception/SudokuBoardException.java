package com.solver.sudoku.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Incorrect Sudoku init values.")
public class SudokuBoardException extends Exception {
}
