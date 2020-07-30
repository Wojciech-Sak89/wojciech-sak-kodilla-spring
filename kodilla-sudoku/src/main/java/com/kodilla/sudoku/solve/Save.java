package com.kodilla.sudoku.solve;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;

import java.util.ArrayDeque;

public class Save {
    public static void currentState(SudokuElement element, int possibleVal, ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard) {
        try {
            backtracks.push(new Backtrack(sudokuBoard.deepCopy(), element.getCoordinate(), possibleVal));
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
