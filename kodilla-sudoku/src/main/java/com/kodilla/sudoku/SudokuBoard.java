package com.kodilla.sudoku;

import com.kodilla.sudoku.util.Coordinate;
import com.kodilla.sudoku.util.Sections;
import com.kodilla.sudoku.util.SudokuTabulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuBoard {
    private final List<SudokuRow> sudokuRows;

    public SudokuBoard() {
        this.sudokuRows = initBoard();
        initSectionsForElements();
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    private ArrayList<SudokuRow> initBoard() {
        ArrayList<SudokuRow> row = new ArrayList<>();
        SudokuRow sudokuRow;

        for (int i = 1; i < 10; i++) {
            sudokuRow = new SudokuRow();
            initRowCoordinate(sudokuRow, i);

            row.add(sudokuRow);
        }
        return row;
    }

    private void initRowCoordinate(SudokuRow sudokuRow, int i) {
        for (SudokuElement sudElement : sudokuRow.getSudokuElements()) {
            sudElement.getCoordinate().setRow(i);
        }
    }

    private void initSectionsForElements() {
        int section;

        for (SudokuRow row : sudokuRows) {
            for (SudokuElement element:
                    row.getSudokuElements()) {
                section = new Sections().determinateSection(element.getCoordinate());
                element.getCoordinate().setSection(section);
            }
        }
    }

    public List<Integer> getRowValues(int row) {
        List<Integer> rowValues = new ArrayList<>();

        SudokuRow sudokuRow = sudokuRows
                .get(SudokuTabulation.setRow(row));

        for (SudokuElement element : sudokuRow.getSudokuElements()) {
            if (!(isEmptySudEl(element))) {
                rowValues.add(element.getValue());
            }
        }
        return rowValues;
    }

    public List<Integer> getColumnValues(int column) {
        List<Integer> columnVals = new ArrayList<>();
        SudokuElement element;

        for (int i = 0; i < 9; i++) {
            element = sudokuRows.get(i)
                    .getSudokuElements()
                    .get(SudokuTabulation.setColumn(column));
            if (!(isEmptySudEl(element))) {
                columnVals.add(element.getValue());
            }
        }
        return columnVals;
    }

    public List<Integer> getSectionValues(int section) {
        List<Coordinate> sectionCoordinates =  new Sections().getSection(section);

        List<Integer> sectionValues = new ArrayList<>();
        SudokuElement element;

        for (Coordinate coordinate : sectionCoordinates) {
            element = sudokuRows
                    .get(SudokuTabulation.setRow(coordinate.getRow()))
                    .getSudokuElements()
                    .get(SudokuTabulation.setColumn(coordinate.getColumn()));
            if (!(isEmptySudEl(element))) {
                sectionValues.add(element.getValue());
            }
        }
        return sectionValues;
    }

    public boolean isValid() {
        Set<Integer> rowValues = new HashSet<>();
        Set<Integer> columnValues = new HashSet<>();
        Set<Integer> blockValues = new HashSet<>();

        List<List<Integer>> sections = initSectionsList();

        if (rowsInvalid(rowValues)) return false;
        if (columnsInvalid(columnValues)) return false;
        if (sectionsInvalid(blockValues, sections)) return false;

        return true;
    }

    private boolean rowsInvalid(Set<Integer> rowValues) {
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

    private boolean columnsInvalid(Set<Integer> columnValues) {
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

    private boolean sectionsInvalid(Set<Integer> blockValues, List<List<Integer>> sections) {
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

    private List<List<Integer>> initSectionsList() {
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

    private boolean isEmptySudEl(SudokuElement sudokuElement) {
        return sudokuElement.getValue() == SudokuElement.EMPTY;
    }

    @Override
    public String toString() {
        int counter = 0;
        String line = "\n---------------------------\n";
        String doubleLine = "\n===========================\n";
        StringBuilder s = new StringBuilder(line);

        for (SudokuRow sudokuRow :
                sudokuRows) {
            counter++;
            s.append(sudokuRow)
                    .append(counter == 3 || counter == 6 ? doubleLine : line);
        }

        return s.toString();
    }
}



