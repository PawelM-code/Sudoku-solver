package com.solver.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuElements;

    SudokuRow(ArrayList<SudokuElement> sudokuElements) {
        this.sudokuElements = sudokuElements;
    }

    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }
}
