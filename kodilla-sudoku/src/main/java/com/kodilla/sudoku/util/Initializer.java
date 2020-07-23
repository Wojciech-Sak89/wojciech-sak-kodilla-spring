package com.kodilla.sudoku.util;

import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuRow;

import java.util.ArrayList;
import java.util.List;

public class Initializer {

    public static ArrayList<Integer> initPossibleValues() {
        ArrayList<Integer> standardPossibleValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            standardPossibleValues.add(i);
        }

        return standardPossibleValues;
    }

    public static ArrayList<SudokuElement> initRow() {
        ArrayList<SudokuElement> row = new ArrayList<>();
        SudokuElement sudokuElement;

        for (int i = 1; i < 10; i++) {
            sudokuElement = new SudokuElement();
            sudokuElement.setCoordinate(new Coordinate(i, 0));

            row.add(sudokuElement);
        }

        return row;
    }

    public static ArrayList<SudokuRow> initBoard() {
        ArrayList<SudokuRow> row = new ArrayList<>();
        SudokuRow sudokuRow;

        for (int i = 1; i < 10; i++) {
            sudokuRow = new SudokuRow();
            initRowCoordinate(sudokuRow, i);

            row.add(sudokuRow);
        }
        return row;
    }

    private static void initRowCoordinate(SudokuRow sudokuRow, int i) {
        for (SudokuElement sudElement : sudokuRow.getSudokuElements()) {
            sudElement.getCoordinate().setRow(i);
        }
    }

    public static void initSectionsForElements(List<SudokuRow> sudokuRows) {
        int section;

        for (SudokuRow row : sudokuRows) {
            for (SudokuElement element:
                    row.getSudokuElements()) {
                section = new Sections().determinateSection(element.getCoordinate());
                element.getCoordinate().setSection(section);
            }
        }
    }

    public static List<List<Integer>> initSectionsList() {
        List<Integer> beginning = new ArrayList<>();
        List<Integer> center = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        beginning.add(0);
        beginning.add(1);
        beginning.add(2);
        center.add(3);
        center.add(4);
        center.add(5);
        end.add(6);
        end.add(7);
        end.add(8);

        List<List<Integer>> sections = new ArrayList<>();
        sections.add(beginning);
        sections.add(center);
        sections.add(end);

        return sections;
    }
}
