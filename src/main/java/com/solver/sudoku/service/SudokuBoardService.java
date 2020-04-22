package com.solver.sudoku.service;

import com.solver.sudoku.domain.SudokuBoard;
import com.solver.sudoku.exception.SudokuBoardException;
import com.solver.sudoku.logic.SudokuLogic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class SudokuBoardService {
    public SudokuBoard getSudokuBoard(String input) throws CloneNotSupportedException, SudokuBoardException {
        SudokuBoard sudokuBoard = new SudokuBoard();

        if (input.length() % 3 == 0) {
            String[] boardElements = input.split("(?<=\\G.{" + 3 + "})");
            for (String boardElement : boardElements) {
                int row = Integer.valueOf(boardElement.substring(0, 1)) - 1;
                int col = Integer.valueOf(boardElement.substring(1, 2)) - 1;
                int value = Integer.valueOf(boardElement.substring(2, 3));
                ArrayList<Integer> allowedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                if (allowedNumbers.contains(value)) {
                    sudokuBoard.setValueInSudokuElement(row, col, value);
                } else {
                    throw new SudokuBoardException();
                }
            }
        } else {
            throw new SudokuBoardException();
        }
        SudokuLogic sudokuLogic = new SudokuLogic();
        sudokuLogic.insertMissingValuesIntoSudokuBoard(sudokuBoard);

        return sudokuBoard;
    }
}
