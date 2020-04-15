package com.solver.sudoku.domain;

import com.solver.sudoku.prototype.Prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> sudokuBoard = new ArrayList<>();

    public SudokuBoard() {
    }

    public void setSudokuBoard(List<SudokuRow> sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void initSudokuBoard() {
        for (int row = 0; row < 9; row++) {
            ArrayList<SudokuElement> initRowList = new ArrayList<>();
            SudokuRow sudokuRow = new SudokuRow(initRowList);
            for (int col = 0; col < 9; col++) {
                initRowList.add(new SudokuElement(SudokuElement.EMPTY, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))));
            }
            sudokuBoard.add(sudokuRow);
        }
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedSudokuBoard = (SudokuBoard) super.clone();
        clonedSudokuBoard.sudokuBoard = new ArrayList<>();
        for (SudokuRow sudokuRowList : sudokuBoard) {
            ArrayList<SudokuElement> sudokuElements = new ArrayList<>();
            SudokuRow clonedSudokuRow = new SudokuRow(sudokuElements);
            for (SudokuElement element : sudokuRowList.getSudokuElements()) {
                SudokuElement elementCopy = new SudokuElement(element.getValue(),new ArrayList<>(element.getListOfAllPossibleElementValues()));
                sudokuElements.add(elementCopy);
            }
            clonedSudokuBoard.getSudokuBoard().add(clonedSudokuRow);
        }
        return clonedSudokuBoard;
    }

    public List<SudokuRow> getSudokuBoard() {
        return sudokuBoard;
    }

    public void setValueInSudokuElement(int row, int col, int value) {
        getSudokuBoard().get(row).getSudokuElements().get(col).setValue(value);
        getSudokuBoardElement(row, col).getListOfAllPossibleElementValues().clear();
    }

    public SudokuElement getSudokuBoardElement(int row, int col){
        return getSudokuBoard()
                .get(row)
                .getSudokuElements()
                .get(col);
    }

    public int getValueOfSudokuElement(int row, int col) {
        return getSudokuBoard()
                .get(row)
                .getSudokuElements()
                .get(col)
                .getValue();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < 9; row++) {
            builder.append("  ");
            for (int col = 0; col < 9; col++) {
                builder.append("|---");
            }

            builder.append("|");
            builder.append("\n");
            builder.append(row).append(" ");

            for (int col = 0; col < 9; col++) {
                builder.append("|");
                builder.append(" ");
                if (getSudokuBoard().get(row).getSudokuElements().get(col).getValue() == SudokuElement.EMPTY) {
                    builder.append(" ");
                } else {
                    builder.append(getSudokuBoard().get(row).getSudokuElements().get(col).getValue());
                }
                builder.append(" ");
            }

            builder.append("|");
            builder.append("\n");
        }
        builder.append("  ");
        for (int col = 0; col < 9; col++) {
            builder.append("|---");
        }
        builder.append("|");
        builder.append("  ");
        builder.append("\n");
        builder.append("  ");

        for (int col = 0; col < 9; col++) {
            builder.append(" ");
            builder.append(" ");
            builder.append(col);
            builder.append(" ");
        }

        return builder.toString();
    }
}
