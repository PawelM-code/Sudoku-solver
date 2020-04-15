package com.solver.sudoku;

import java.util.ArrayList;

class SudokuElement {
    static int EMPTY = -1;
    private int value;
    private ArrayList<Integer> listOfAllPossibleElementValues;

    SudokuElement(int value, ArrayList<Integer> listOfAllPosibleSudokuValues) {
        this.value = value;
        this.listOfAllPossibleElementValues = listOfAllPosibleSudokuValues;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    ArrayList<Integer> getListOfAllPossibleElementValues() {
        return listOfAllPossibleElementValues;
    }

    void setListOfAllPossibleElementValues(ArrayList<Integer> listOfAllPossibleElementValues) {
        this.listOfAllPossibleElementValues = listOfAllPossibleElementValues;
    }
}
