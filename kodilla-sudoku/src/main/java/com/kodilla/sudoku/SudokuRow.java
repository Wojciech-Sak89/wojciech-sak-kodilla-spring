package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private final List<SudokuElement> sudokuElements;

    public SudokuRow() {
        this.sudokuElements = initRow();
    }

    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }

    private ArrayList<SudokuElement> initRow() {
        ArrayList<SudokuElement> row = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            row.add(new SudokuElement());
        }

        return row;
    }

    @Override
    public String toString() {
        int counter = 0;
        StringBuilder s = new StringBuilder("||");

        for (SudokuElement sudokuElement:
             sudokuElements) {
            counter++;
            s.append(sudokuElement).append(counter == 3 || counter == 6 ? " ** " : "|");
        }

        s.append("|");

        return s.toString();
    }
}