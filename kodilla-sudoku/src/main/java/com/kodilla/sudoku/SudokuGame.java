package com.kodilla.sudoku;

import com.kodilla.sudoku.util.SudokuTabulation;

public class SudokuGame {

    private SudokuBoard sudokuBoard;

    public SudokuGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean resolveSudoku() {
        return false;
    }

    private boolean setBoardValue(int sudokuColumn, int sudokuRow, Integer sudokuValue) {
        return sudokuBoard
                .getSudokuRows().get(sudokuRow)
                .getSudokuElements().get(sudokuColumn)
                .setValue(sudokuValue);
    }

    public void userSetValue(String userInput) {
        String[] input = userInput.split(",");

        setBoardValue(SudokuTabulation.setColumn(input[0]), SudokuTabulation.setRow(input[0]), Integer.parseInt(input[2]));

    }

    public void displayBoard() {
        System.out.println(sudokuBoard);
    }
}
