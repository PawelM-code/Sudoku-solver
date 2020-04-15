package com.solver.sudoku;

import java.util.ArrayList;

public class SudokuRow {
    private ArrayList<SudokuElement> sudokuElements;

    SudokuRow(ArrayList<SudokuElement> sudokuElements) {
        this.sudokuElements = sudokuElements;
    }

    ArrayList<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }

    public void setSudokuElements(ArrayList<SudokuElement> sudokuElements) {
        this.sudokuElements = sudokuElements;
    }
}
