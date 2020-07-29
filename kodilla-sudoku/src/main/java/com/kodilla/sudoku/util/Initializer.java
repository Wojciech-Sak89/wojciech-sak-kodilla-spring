package com.kodilla.sudoku.util;

import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<Coordinate, Integer> initSectionsForCoordinatesMap() {
        Map<Coordinate, Integer> coordinatesForSections = new HashMap<>();

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(1)), 1);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(1)), 1);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(1)), 1);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(2)), 1);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(2)), 1);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(2)), 1);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(3)), 1);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(3)), 1);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(3)), 1);

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(1)), 2);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(1)), 2);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(1)), 2);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(2)), 2);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(2)), 2);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(2)), 2);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(3)), 2);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(3)), 2);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(3)), 2);

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(1)), 3);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(1)), 3);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(1)), 3);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(2)), 3);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(2)), 3);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(2)), 3);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(3)), 3);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(3)), 3);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(3)), 3);

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(4)), 4);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(4)), 4);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(4)), 4);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(5)), 4);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(5)), 4);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(5)), 4);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(6)), 4);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(6)), 4);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(6)), 4);

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(4)), 5);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(4)), 5);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(4)), 5);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(5)), 5);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(5)), 5);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(5)), 5);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(6)), 5);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(6)), 5);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(6)), 5);

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(4)), 6);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(4)), 6);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(4)), 6);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(5)), 6);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(5)), 6);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(5)), 6);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(6)), 6);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(6)), 6);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(6)), 6);

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(7)), 7);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(7)), 7);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(7)), 7);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(8)), 7);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(8)), 7);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(8)), 7);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(9)), 7);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(9)), 7);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(9)), 7);

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(7)), 8);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(7)), 8);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(7)), 8);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(8)), 8);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(8)), 8);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(8)), 8);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(9)), 8);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(9)), 8);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(9)), 8);

        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(7)), 9);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(7)), 9);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(7)), 9);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(8)), 9);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(8)), 9);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(8)), 9);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(9)), 9);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(9)), 9);
        coordinatesForSections.put(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(9)), 9);

        return coordinatesForSections;
    }
}
