package com.solver.sudoku.domain;

import java.util.ArrayList;

public class SudokuElement {
    public static int EMPTY = -1;
    private int value;
    private ArrayList<Integer> listOfAllPossibleElementValues;

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

    public ArrayList<Integer> getListOfAllPossibleElementValues() {
        return listOfAllPossibleElementValues;
    }

    public void setListOfAllPossibleElementValues(ArrayList<Integer> listOfAllPossibleElementValues) {
        this.listOfAllPossibleElementValues = listOfAllPossibleElementValues;
    }
}
