package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> sudokuRows;

    public SudokuBoard() {
        this.sudokuRows = initBoard();
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    private ArrayList<SudokuRow> initBoard() {
        ArrayList<SudokuRow> row = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            row.add(new SudokuRow());
        }

        return row;
    }

    @Override
    public String toString() {
        int counter = 0;
        String line = "\n---------------------------\n";
        String doubleLine = "\n===========================\n";
        StringBuilder s = new StringBuilder(line);

        for (SudokuRow sudokuRow:
             sudokuRows) {
            counter++;
            s.append(sudokuRow).append(counter == 3 || counter == 6 ? doubleLine : line);
        }

        return s.toString();
    }
}



