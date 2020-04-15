package com.solver.sudoku.domain;

public class SudokuBoardCoordinates {
    private int row;
    private int col;

    public SudokuBoardCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
