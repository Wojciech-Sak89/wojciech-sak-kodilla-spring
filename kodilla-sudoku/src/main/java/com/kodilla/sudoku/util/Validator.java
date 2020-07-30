package com.kodilla.sudoku.util;

import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuRow;

import java.util.List;
import java.util.Set;

public class Validator {

    public static boolean rowsInvalid(Set<Integer> rowValues, List<SudokuRow> sudokuRows) {
        for (SudokuRow row : sudokuRows) {
            for (SudokuElement element : row.getSudokuElements()) {
                if (!(isEmptySudEl(element))) {
                    if (!rowValues.add(element.getValue())) {
                        return true;
                    }
                }
            }
            rowValues.clear();
        }
        return false;
    }

    public static boolean columnsInvalid(Set<Integer> columnValues, List<SudokuRow> sudokuRows) {
        SudokuElement sudokuElement;
        for (int i = 0; i < 9; i++) {
            for (SudokuRow row : sudokuRows) {
                sudokuElement = row.getSudokuElements().get(i);
                if (!(isEmptySudEl(sudokuElement))) {
                    if (!columnValues.add(
                            sudokuElement.getValue())) {
                        return true;
                    }
                }
            }
            columnValues.clear();
        }
        return false;
    }

    public static boolean sectionsInvalid(Set<Integer> blockValues, List<List<Integer>> sections, List<SudokuRow> sudokuRows) { // simplify
        SudokuElement sudokuElement;
        for (List<Integer> sectionHorizontal : sections) {
            for (List<Integer> sectionVertical : sections) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sudokuElement = sudokuRows
                                .get(sectionHorizontal.get(i))
                                .getSudokuElements()
                                .get(sectionVertical.get(j));

                        if (!(isEmptySudEl(sudokuElement))) {
                            if (!blockValues.add(
                                    sudokuElement.getValue())) {
                                return true;
                            }
                        }

                    }
                }
                blockValues.clear();
            }
        }
        return false;
    }

    public static boolean isEmptySudEl(SudokuElement sudokuElement) {
        return sudokuElement.getValue() == SudokuElement.EMPTY;
    }
}
