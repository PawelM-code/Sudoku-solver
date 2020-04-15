package com.solver.sudoku.domain;

public class Backtrack {
    private SudokuBoard sudokuBoard;
    private int row;
    private int col;
    private int guessedValue;

    public Backtrack(SudokuBoard sudokuBoard, int row, int col, int guessedValue) {
        this.sudokuBoard = sudokuBoard;
        this.row = row;
        this.col = col;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getGuessedValue() {
        return guessedValue;
    }
}
