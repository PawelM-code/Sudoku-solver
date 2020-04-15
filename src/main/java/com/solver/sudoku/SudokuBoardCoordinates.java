package com.solver.sudoku;

class SudokuBoardCoordinates {
    private int row;
    private int col;

    SudokuBoardCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }
}
