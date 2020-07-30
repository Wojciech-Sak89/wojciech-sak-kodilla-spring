package com.kodilla.sudoku.solve;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.util.Coordinate;

public class Backtrack {
    private SudokuBoard sudokuBoard;
    private final Coordinate coordinate;
    private final int guessNumber;

    public Backtrack(SudokuBoard sudokuBoard, Coordinate coordinate, int guessNumber) {
        this.sudokuBoard = sudokuBoard;
        this.coordinate = coordinate;
        this.guessNumber = guessNumber;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    @Override
    public String toString() {
        return "Backtrack{" +
                "sudokuBoard=" + sudokuBoard +
                ", coordinate=" + coordinate +
                ", guessNumber=" + guessNumber +
                '}';
    }
}
