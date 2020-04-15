package com.solver.sudoku;

import java.util.ArrayList;
import java.util.Random;

public class SudokuLogic {
    private ArrayList<Backtrack> backtracks = new ArrayList<>();

    public void insertMissingValuesIntoSudokuBoard(SudokuBoard sudokuBoard) throws CloneNotSupportedException {
        while (isEmptyValueOnTheBoard(sudokuBoard)) {
            SudokuBoard startSudokuBoard = sudokuBoard.deepCopy();

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    int elementValue = sudokuBoard.getValueOfSudokuElement(row, col);

                    removeUsedValuesFromElementsCollection(sudokuBoard, row, col, elementValue);
                }
            }

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (isOnlyOneValueInListOfAllPossibleElementValues(sudokuBoard, row, col)) {
                        int value = getFirstValueOfElementPossibleValues(sudokuBoard, row, col);
                        setConfirmedNewValueOnTheSuokuBoard(sudokuBoard, row, col, value);
                    }
                }
            }

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    int elementValue = sudokuBoard.getValueOfSudokuElement(row, col);
                    if (elementValue == SudokuElement.EMPTY) {
                        setPossibleValueIfIsNoSetValueOrPossibleValueInOtherElementsInRowSearch(sudokuBoard, row, col);
                        setPossibleValueIfIsNoSetValueOrPossibleValueInOtherElementsInColumnSearch(sudokuBoard, row, col);
                        setPossibleValueIfIsNoSetValueOrPossibleValueInOtherElementsInColumnSearchInSectionSearch(sudokuBoard, row, col);
                    }
                }
            }

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    int elementValue = sudokuBoard.getValueOfSudokuElement(row, col);

                    if (isElementValueAndPossibleValuesEmpty(sudokuBoard, row, col, elementValue)) {
                        exeptionHandling(sudokuBoard);
                        break;
                    }
                    if (isElementValueNotEmptyAndUsedInOtherElement(sudokuBoard, row, col, elementValue)) {
                        exeptionHandling(sudokuBoard);
                        break;
                    }

                    if (elementValue == SudokuElement.EMPTY && isOnlyOneValueInListOfAllPossibleElementValues(sudokuBoard, row, col)) {
                        int value = getFirstValueOfElementPossibleValues(sudokuBoard, row, col);
                        if (isValueUsedInOtherElements(sudokuBoard, row, col, value)) {
                            exeptionHandling(sudokuBoard);
                            break;
                        }
                    }
                }
            }

            if (isNoProgress(sudokuBoard, startSudokuBoard)) {
                addBacktrackToTheList(sudokuBoard);
                setGuessedValue(sudokuBoard);
            }
        }
    }

    private boolean isEmptyValueOnTheBoard(SudokuBoard sudokuBoard) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuBoard.getValueOfSudokuElement(row, col) == SudokuElement.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    private void removeUsedValuesFromElementsCollection(SudokuBoard sudokuBoard, int row, int col, int elementValue) {
        if (elementValue == SudokuElement.EMPTY) {
            removeUsedValuesFromElementsCollectionRowSearch(sudokuBoard, row, col);
            removeUsedValuesFromElementsCollectionColumnSearch(sudokuBoard, row, col);
            removeUsedValuesFromElementsCollectionSectionSearch(sudokuBoard, row, col);
        }
    }

    private void removeUsedValuesFromElementsCollectionRowSearch(SudokuBoard sudokuBoard, int row, int col) {
        ArrayList<Integer> elementPossibleValues = getAllPossibleElementValues(sudokuBoard, row, col);
        ArrayList<Integer> elementPossibleValuesWithoutUsedValues = new ArrayList<>(elementPossibleValues);

        for (Integer integer : elementPossibleValues) {
            sudokuBoard.getSudokuBoard()
                    .get(row)
                    .getSudokuElements()
                    .forEach(element -> {
                        if (integer == element.getValue()) {
                            elementPossibleValuesWithoutUsedValues.remove(integer);
                        }
                    });
        }

        sudokuBoard.getSudokuBoardElement(row, col)
                .setListOfAllPossibleElementValues(elementPossibleValuesWithoutUsedValues);
    }

    private void removeUsedValuesFromElementsCollectionColumnSearch(SudokuBoard sudokuBoard, int row, int col) {
        ArrayList<Integer> elementPossibleValues = getAllPossibleElementValues(sudokuBoard, row, col);
        ArrayList<Integer> elementPossibleValuesWithoutUsedValues = new ArrayList<>(elementPossibleValues);

        for (Integer integer : elementPossibleValues) {
            sudokuBoard.getSudokuBoard()
                    .forEach(r -> {
                        if (integer == r
                                .getSudokuElements()
                                .get(col)
                                .getValue()) {
                            elementPossibleValuesWithoutUsedValues.remove(integer);
                        }
                    });
        }

        sudokuBoard.getSudokuBoardElement(row, col)
                .setListOfAllPossibleElementValues(elementPossibleValuesWithoutUsedValues);
    }

    private void removeUsedValuesFromElementsCollectionSectionSearch(SudokuBoard sudokuBoard, int row, int col) {
        ArrayList<Integer> elementPossibleValues = getAllPossibleElementValues(sudokuBoard, row, col);
        ArrayList<Integer> elementPossibleValuesWithoutUsedValues = new ArrayList<>(elementPossibleValues);

        int r = row - row % 3;
        int c = col - col % 3;

        for (Integer integer : elementPossibleValues) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    if (integer == sudokuBoard.getSudokuBoardElement(i, j).getValue()) {
                        elementPossibleValuesWithoutUsedValues.remove(integer);
                    }
                }
            }
        }

        sudokuBoard.getSudokuBoardElement(row, col)
                .setListOfAllPossibleElementValues(elementPossibleValuesWithoutUsedValues);
    }

    private boolean isOnlyOneValueInListOfAllPossibleElementValues(SudokuBoard sudokuBoard, int row, int col) {
        return sudokuBoard.getSudokuBoardElement(row, col)
                .getListOfAllPossibleElementValues().size() == 1;
    }

    private Integer getFirstValueOfElementPossibleValues(SudokuBoard sudokuBoard, int row, int col) {
        return sudokuBoard.getSudokuBoardElement(row, col).getListOfAllPossibleElementValues().get(0);
    }

    private void setConfirmedNewValueOnTheSuokuBoard(SudokuBoard sudokuBoard, int row, int col, int value) {
        if (!isValueUsedInOtherElements(sudokuBoard, row, col, value)) {
            sudokuBoard.setValueInSudokuElement(row, col, value);
            sudokuBoard.getSudokuBoardElement(row, col).getListOfAllPossibleElementValues().clear();
        }
    }

    private boolean isValueUsedInOtherElements(SudokuBoard sudokuBoard, int row, int col, int value) {
        if (isValueUsedInSection(sudokuBoard, row, col, value)) return true;
        if (isValueUsedInColumn(sudokuBoard, row, col, value)) return true;
        if (isValueUsedInRow(sudokuBoard, row, col, value)) return true;

        return false;
    }

    private boolean isValueUsedInRow(SudokuBoard sudokuBoard, int row, int col, int value) {
        for (int col2 = 0; col2 < 9; col2++) {
            if (col != col2) {
                if (sudokuBoard.getSudokuBoard()
                        .get(row)
                        .getSudokuElements()
                        .get(col2)
                        .getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValueUsedInColumn(SudokuBoard sudokuBoard, int row, int col, int value) {
        for (int row2 = 0; row2 < 9; row2++) {
            if (row != row2) {
                if (sudokuBoard.getSudokuBoard()
                        .get(row2)
                        .getSudokuElements()
                        .get(col)
                        .getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValueUsedInSection(SudokuBoard sudokuBoard, int row, int col, int value) {
        int r = row - (row % 3);
        int c = col - (col % 3);

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (row != i || col != j) {
                    if (value == sudokuBoard.getSudokuBoardElement(i, j)
                            .getValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void setPossibleValueIfIsNoSetValueOrPossibleValueInOtherElementsInRowSearch(SudokuBoard sudokuBoard, int row, int col) {
        ArrayList<Integer> elementPossibleValues = getAllPossibleElementValues(sudokuBoard, row, col);
        ArrayList<Integer> allRowElementsPossibleValues = getAllRowOrColumnElementValueAndPossibleValuesWithoutCurrentElement(sudokuBoard, row, col);

        for (Integer integer : elementPossibleValues) {
            if (!allRowElementsPossibleValues.contains(integer)) {
                sudokuBoard.setValueInSudokuElement(row, col, integer);
                break;
            }
        }
    }

    private ArrayList<Integer> getAllRowOrColumnElementValueAndPossibleValuesWithoutCurrentElement(SudokuBoard sudokuBoard, int row, int col) {
        ArrayList<Integer> allElementsPossibleValues = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            if (i != col) {
                addPossibleValuesToTheList(sudokuBoard, i, allElementsPossibleValues, row);
                addValueToTheList(sudokuBoard, row, allElementsPossibleValues, i);
            }
        }
        return allElementsPossibleValues;
    }

    private void addPossibleValuesToTheList(SudokuBoard sudokuBoard, int col, ArrayList<Integer> allElementsPossibleValues, int i) {
        allElementsPossibleValues.addAll(sudokuBoard.getSudokuBoard()
                .get(i)
                .getSudokuElements()
                .get(col)
                .getListOfAllPossibleElementValues());
    }

    private void addValueToTheList(SudokuBoard sudokuBoard, int row, ArrayList<Integer> allElementsPossibleValues, int i) {
        allElementsPossibleValues.add(sudokuBoard.getSudokuBoard()
                .get(row)
                .getSudokuElements()
                .get(i)
                .getValue());
    }

    private ArrayList<Integer> getAllPossibleElementValues(SudokuBoard sudokuBoard, int row, int col) {
        return sudokuBoard
                .getSudokuBoardElement(row, col)
                .getListOfAllPossibleElementValues();
    }

    private void setPossibleValueIfIsNoSetValueOrPossibleValueInOtherElementsInColumnSearch(SudokuBoard sudokuBoard, int row, int col) {
        ArrayList<Integer> elementPossibleValues = getAllPossibleElementValues(sudokuBoard, row, col);

        ArrayList<Integer> allColumnElementsPossibleValues = getAllRowOrColumnElementValueAndPossibleValuesWithoutCurrentElement(sudokuBoard, row, col);

        for (Integer integer : elementPossibleValues) {
            if (!allColumnElementsPossibleValues.contains(integer)) {
                if (!isValueUsedInOtherElements(sudokuBoard, row, col, integer)) {
                    sudokuBoard.setValueInSudokuElement(row, col, integer);
                    break;
                }
            }
        }
    }

    private void setPossibleValueIfIsNoSetValueOrPossibleValueInOtherElementsInColumnSearchInSectionSearch(SudokuBoard sudokuBoard, int row, int col) {
        ArrayList<Integer> elementPossibleValue = getAllPossibleElementValues(sudokuBoard, row, col);

        ArrayList<Integer> allSectionElementsPossibleValues = new ArrayList<>();

        int r = row - (row % 3);
        int c = col - (col % 3);

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (i != row || j != col) {
                    allSectionElementsPossibleValues.addAll(sudokuBoard
                            .getSudokuBoardElement(i, j)
                            .getListOfAllPossibleElementValues());

                    allSectionElementsPossibleValues.add(sudokuBoard
                            .getSudokuBoardElement(i, j)
                            .getValue());
                }
            }
        }
        for (Integer integer : elementPossibleValue) {
            if (!allSectionElementsPossibleValues.contains(integer)) {
                sudokuBoard.setValueInSudokuElement(row, col, integer);
                break;
            }
        }
    }

    private boolean isElementValueAndPossibleValuesEmpty(SudokuBoard sudokuBoard, int row, int col, int elementValue) {
        return elementValue == SudokuElement.EMPTY &&
                sudokuBoard.getSudokuBoardElement(row, col).getListOfAllPossibleElementValues().size() == 0;
    }

    private boolean isElementValueNotEmptyAndUsedInOtherElement(SudokuBoard sudokuBoard, int row, int col, int elementValue) {
        return elementValue != SudokuElement.EMPTY && isValueUsedInOtherElements(sudokuBoard, row, col, elementValue);
    }

    private void exeptionHandling(SudokuBoard sudokuBoard) {
        if (backtracks.size() == 0) {
            System.out.println("Incorrect Sudoku init values.");
            System.exit(0);
        } else {
            int numberOfNewestBacktrack = backtracks.size() - 1;
            int rowBacktrack = backtracks.get(numberOfNewestBacktrack).getRow();
            int colBacktrack = backtracks.get(numberOfNewestBacktrack).getCol();
            int guessedValueBacktrack = backtracks.get(numberOfNewestBacktrack).getGuessedValue();

            sudokuBoard.setSudokuBoard(backtracks.get(numberOfNewestBacktrack).getSudokuBoard().getSudokuBoard());

            sudokuBoard.getSudokuBoardElement(rowBacktrack, colBacktrack)
                    .getListOfAllPossibleElementValues()
                    .removeIf(v -> v == guessedValueBacktrack);

            backtracks.remove(numberOfNewestBacktrack);
        }
    }

    private boolean isNoProgress(SudokuBoard sudokuBoard, SudokuBoard startSudokuBoard) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuBoard.getValueOfSudokuElement(row, col) != startSudokuBoard.getValueOfSudokuElement(row, col)
                        ||
                        sudokuBoard.getSudokuBoardElement(row, col).getListOfAllPossibleElementValues().size() !=
                                startSudokuBoard.getSudokuBoardElement(row, col).getListOfAllPossibleElementValues().size()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void addBacktrackToTheList(SudokuBoard sudokuBoard) throws CloneNotSupportedException {
        SudokuBoard sudokuBoardCopy = sudokuBoard.deepCopy();
        ArrayList<SudokuBoardCoordinates> sudokuEmptyBoardPointsList = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int elementValue = sudokuBoard.getValueOfSudokuElement(row, col);
                if (elementValue == SudokuElement.EMPTY) {
                    sudokuEmptyBoardPointsList.add(new SudokuBoardCoordinates(row, col));
                }
            }
        }

        Random random = new Random();
        int randomNumberOfSudokuEmptyBoardList = random.nextInt(sudokuEmptyBoardPointsList.size());
        SudokuBoardCoordinates sudokuBoardCoordinates = sudokuEmptyBoardPointsList.get(randomNumberOfSudokuEmptyBoardList);

        int guessedValue = getFirstValueOfElementPossibleValues(sudokuBoard, sudokuBoardCoordinates.getRow(), sudokuBoardCoordinates.getCol());

        Backtrack backtrack = new Backtrack(sudokuBoardCopy, sudokuBoardCoordinates.getRow(), sudokuBoardCoordinates.getCol(), guessedValue);
        this.backtracks.add(backtrack);
    }

    private void setGuessedValue(SudokuBoard sudokuBoard) {
        int numberOfNewestBackract = backtracks.size() - 1;
        int row = backtracks.get(numberOfNewestBackract).getRow();
        int col = backtracks.get(numberOfNewestBackract).getCol();
        int guessedValue = backtracks.get(numberOfNewestBackract).getGuessedValue();
        sudokuBoard.setValueInSudokuElement(row, col, guessedValue);
    }
}
