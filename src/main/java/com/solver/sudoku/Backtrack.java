package com.solver.sudoku;

class Backtrack {
    private SudokuBoard sudokuBoard;
    private int row;
    private int col;
    private int guessedValue;

    Backtrack(SudokuBoard sudokuBoard, int row, int col, int guessedValue) {
        this.sudokuBoard = sudokuBoard;
        this.row = row;
        this.col = col;
        this.guessedValue = guessedValue;
    }

    SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    int getGuessedValue() {
        return guessedValue;
    }
}
