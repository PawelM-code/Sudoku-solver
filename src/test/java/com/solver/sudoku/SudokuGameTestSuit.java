package com.solver.sudoku;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class SudokuGameTestSuit {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testSudokuBoardIncorrectInitValues() throws CloneNotSupportedException {
        //given
        exit.expectSystemExitWithStatus(0);

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initSudokuBoard();

        sudokuBoard.setValueInSudokuElement(0, 0, 2);
        sudokuBoard.setValueInSudokuElement(0, 1, 2);

        SudokuLogic sudokuLogic = new SudokuLogic();

        //then
        sudokuLogic.insertMissingValuesIntoSudokuBoard(sudokuBoard);
    }

    @Test
    public void testSudokuGameBoard() throws CloneNotSupportedException {
        //given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initSudokuBoard();

        sudokuBoard.setValueInSudokuElement(0, 0, 8);

        sudokuBoard.setValueInSudokuElement(1, 2, 3);
        sudokuBoard.setValueInSudokuElement(1, 3, 6);

        sudokuBoard.setValueInSudokuElement(2, 1, 7);
        sudokuBoard.setValueInSudokuElement(2, 4, 9);
        sudokuBoard.setValueInSudokuElement(2, 6, 2);

        sudokuBoard.setValueInSudokuElement(3, 1, 5);
        sudokuBoard.setValueInSudokuElement(3, 5, 7);

        sudokuBoard.setValueInSudokuElement(4, 4, 4);
        sudokuBoard.setValueInSudokuElement(4, 5, 5);
        sudokuBoard.setValueInSudokuElement(4, 6, 7);

        sudokuBoard.setValueInSudokuElement(5, 3, 1);
        sudokuBoard.setValueInSudokuElement(5, 7, 3);

        sudokuBoard.setValueInSudokuElement(6, 2, 1);
        sudokuBoard.setValueInSudokuElement(6, 7, 6);
        sudokuBoard.setValueInSudokuElement(6, 8, 8);

        sudokuBoard.setValueInSudokuElement(7, 2, 8);
        sudokuBoard.setValueInSudokuElement(7, 3, 5);
        sudokuBoard.setValueInSudokuElement(7, 7, 1);

        sudokuBoard.setValueInSudokuElement(8, 1, 9);
        sudokuBoard.setValueInSudokuElement(8, 6, 4);

        SudokuLogic sudokuLogic = new SudokuLogic();

        SudokuBoard sudokuBoardResult = new SudokuBoard();
        sudokuBoardResult.initSudokuBoard();
        sudokuBoardResult.setValueInSudokuElement(0, 0, 8);
        sudokuBoardResult.setValueInSudokuElement(0, 1, 1);
        sudokuBoardResult.setValueInSudokuElement(0, 2, 2);
        sudokuBoardResult.setValueInSudokuElement(0, 3, 7);
        sudokuBoardResult.setValueInSudokuElement(0, 4, 5);
        sudokuBoardResult.setValueInSudokuElement(0, 5, 3);
        sudokuBoardResult.setValueInSudokuElement(0, 6, 6);
        sudokuBoardResult.setValueInSudokuElement(0, 7, 4);
        sudokuBoardResult.setValueInSudokuElement(0, 8, 9);
        sudokuBoardResult.setValueInSudokuElement(1, 0, 9);
        sudokuBoardResult.setValueInSudokuElement(1, 1, 4);
        sudokuBoardResult.setValueInSudokuElement(1, 2, 3);
        sudokuBoardResult.setValueInSudokuElement(1, 3, 6);
        sudokuBoardResult.setValueInSudokuElement(1, 4, 8);
        sudokuBoardResult.setValueInSudokuElement(1, 5, 2);
        sudokuBoardResult.setValueInSudokuElement(1, 6, 1);
        sudokuBoardResult.setValueInSudokuElement(1, 7, 7);
        sudokuBoardResult.setValueInSudokuElement(1, 8, 5);
        sudokuBoardResult.setValueInSudokuElement(2, 0, 6);
        sudokuBoardResult.setValueInSudokuElement(2, 1, 7);
        sudokuBoardResult.setValueInSudokuElement(2, 2, 5);
        sudokuBoardResult.setValueInSudokuElement(2, 3, 4);
        sudokuBoardResult.setValueInSudokuElement(2, 4, 9);
        sudokuBoardResult.setValueInSudokuElement(2, 5, 1);
        sudokuBoardResult.setValueInSudokuElement(2, 6, 2);
        sudokuBoardResult.setValueInSudokuElement(2, 7, 8);
        sudokuBoardResult.setValueInSudokuElement(2, 8, 3);
        sudokuBoardResult.setValueInSudokuElement(3, 0, 1);
        sudokuBoardResult.setValueInSudokuElement(3, 1, 5);
        sudokuBoardResult.setValueInSudokuElement(3, 2, 4);
        sudokuBoardResult.setValueInSudokuElement(3, 3, 2);
        sudokuBoardResult.setValueInSudokuElement(3, 4, 3);
        sudokuBoardResult.setValueInSudokuElement(3, 5, 7);
        sudokuBoardResult.setValueInSudokuElement(3, 6, 8);
        sudokuBoardResult.setValueInSudokuElement(3, 7, 9);
        sudokuBoardResult.setValueInSudokuElement(3, 8, 6);
        sudokuBoardResult.setValueInSudokuElement(4, 0, 3);
        sudokuBoardResult.setValueInSudokuElement(4, 1, 6);
        sudokuBoardResult.setValueInSudokuElement(4, 2, 9);
        sudokuBoardResult.setValueInSudokuElement(4, 3, 8);
        sudokuBoardResult.setValueInSudokuElement(4, 4, 4);
        sudokuBoardResult.setValueInSudokuElement(4, 5, 5);
        sudokuBoardResult.setValueInSudokuElement(4, 6, 7);
        sudokuBoardResult.setValueInSudokuElement(4, 7, 2);
        sudokuBoardResult.setValueInSudokuElement(4, 8, 1);
        sudokuBoardResult.setValueInSudokuElement(5, 0, 2);
        sudokuBoardResult.setValueInSudokuElement(5, 1, 8);
        sudokuBoardResult.setValueInSudokuElement(5, 2, 7);
        sudokuBoardResult.setValueInSudokuElement(5, 3, 1);
        sudokuBoardResult.setValueInSudokuElement(5, 4, 6);
        sudokuBoardResult.setValueInSudokuElement(5, 5, 9);
        sudokuBoardResult.setValueInSudokuElement(5, 6, 5);
        sudokuBoardResult.setValueInSudokuElement(5, 7, 3);
        sudokuBoardResult.setValueInSudokuElement(5, 8, 4);
        sudokuBoardResult.setValueInSudokuElement(6, 0, 5);
        sudokuBoardResult.setValueInSudokuElement(6, 1, 2);
        sudokuBoardResult.setValueInSudokuElement(6, 2, 1);
        sudokuBoardResult.setValueInSudokuElement(6, 3, 9);
        sudokuBoardResult.setValueInSudokuElement(6, 4, 7);
        sudokuBoardResult.setValueInSudokuElement(6, 5, 4);
        sudokuBoardResult.setValueInSudokuElement(6, 6, 3);
        sudokuBoardResult.setValueInSudokuElement(6, 7, 6);
        sudokuBoardResult.setValueInSudokuElement(6, 8, 8);
        sudokuBoardResult.setValueInSudokuElement(7, 0, 4);
        sudokuBoardResult.setValueInSudokuElement(7, 1, 3);
        sudokuBoardResult.setValueInSudokuElement(7, 2, 8);
        sudokuBoardResult.setValueInSudokuElement(7, 3, 5);
        sudokuBoardResult.setValueInSudokuElement(7, 4, 2);
        sudokuBoardResult.setValueInSudokuElement(7, 5, 6);
        sudokuBoardResult.setValueInSudokuElement(7, 6, 9);
        sudokuBoardResult.setValueInSudokuElement(7, 7, 1);
        sudokuBoardResult.setValueInSudokuElement(7, 8, 7);
        sudokuBoardResult.setValueInSudokuElement(8, 0, 7);
        sudokuBoardResult.setValueInSudokuElement(8, 1, 9);
        sudokuBoardResult.setValueInSudokuElement(8, 2, 6);
        sudokuBoardResult.setValueInSudokuElement(8, 3, 3);
        sudokuBoardResult.setValueInSudokuElement(8, 4, 1);
        sudokuBoardResult.setValueInSudokuElement(8, 5, 8);
        sudokuBoardResult.setValueInSudokuElement(8, 6, 4);
        sudokuBoardResult.setValueInSudokuElement(8, 7, 5);
        sudokuBoardResult.setValueInSudokuElement(8, 8, 2);

        //when
        sudokuLogic.insertMissingValuesIntoSudokuBoard(sudokuBoard);
        boolean result = true;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuBoard.getValueOfSudokuElement(row, col) != sudokuBoardResult.getValueOfSudokuElement(row, col)) {
                    result = false;
                    break;
                }
            }
        }

        //then
        Assert.assertTrue(result);
    }
}
