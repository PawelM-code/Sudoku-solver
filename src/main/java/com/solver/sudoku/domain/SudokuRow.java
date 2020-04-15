package com.solver.sudoku.domain;

import com.solver.sudoku.domain.SudokuElement;

import java.util.ArrayList;

public class SudokuRow {
    private ArrayList<SudokuElement> sudokuElements;

    SudokuRow(ArrayList<SudokuElement> sudokuElements) {
        this.sudokuElements = sudokuElements;
    }

    public ArrayList<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }

    public void setSudokuElements(ArrayList<SudokuElement> sudokuElements) {
        this.sudokuElements = sudokuElements;
    }
}
