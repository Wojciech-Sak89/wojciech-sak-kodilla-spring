package com.kodilla.sudoku;

import com.kodilla.sudoku.util.Initializer;

import java.util.List;

public class SudokuRow {
    private final List<SudokuElement> sudokuElements;

    public SudokuRow() {
        this.sudokuElements = Initializer.initRow();
    }

    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }

    @Override
    public String toString() {
        int counter = 0;
        StringBuilder s = new StringBuilder("||");

        for (SudokuElement sudokuElement:
             sudokuElements) {
            counter++;
            s.append(sudokuElement.getValue()).append(counter == 3 || counter == 6 ? " ** " : "|");
        }

        s.append("|");

        return s.toString();
    }
}