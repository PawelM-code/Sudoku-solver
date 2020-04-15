package com.solver.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;
    private int value;
    private List<Integer> listOfAllPossibleElementValues;

    SudokuElement(int value, ArrayList<Integer> listOfAllPosibleSudokuValues) {
        this.value = value;
        this.listOfAllPossibleElementValues = listOfAllPosibleSudokuValues;
    }

    public int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getListOfAllPossibleElementValues() {
        return listOfAllPossibleElementValues;
    }

    public void setListOfAllPossibleElementValues(List<Integer> listOfAllPossibleElementValues) {
        this.listOfAllPossibleElementValues = listOfAllPossibleElementValues;
    }
}
