package com.kodilla.sudoku;

import com.kodilla.sudoku.solve.Prototype;
import com.kodilla.sudoku.exceptions.SudokuUnsolvable;
import com.kodilla.sudoku.util.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SudokuBoard extends Prototype {
    private List<SudokuRow> sudokuRows;

    public SudokuBoard() {
        this.sudokuRows = Initializer.initBoard();
        Initializer.initSectionsForElements(sudokuRows);
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public List<Integer> getRowValues(int row) {
//        System.out.println("getRowValues(int row) row=" + row);
        List<Integer> rowValues = new ArrayList<>();

        SudokuRow sudokuRow = sudokuRows
                .get(Tabulation.calculateRow(row));

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
                    .get(Tabulation.calculateColumn(column));
            if (!(isEmptySudEl(element))) {
                columnVals.add(element.getValue());
            }
        }
        return columnVals;
    }

    public List<Integer> getSectionValues(int section) {
        List<Coordinate> sectionCoordinates = new Sections().getSection(section);

        List<Integer> sectionValues = new ArrayList<>();
        SudokuElement element;

        for (Coordinate coordinate : sectionCoordinates) {
            element = sudokuRows
                    .get(Tabulation.calculateRow(coordinate.getRow()))
                    .getSudokuElements()
                    .get(Tabulation.calculateColumn(coordinate.getColumn()));
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

        List<List<Integer>> sections = Initializer.initSectionsList();

        if (Validator.rowsInvalid(rowValues, sudokuRows)) return false;
        if (Validator.columnsInvalid(columnValues, sudokuRows)) return false;
        if (Validator.sectionsInvalid(blockValues, sections, sudokuRows)) return false;

        return true;
    }

    public boolean isContradictory() {
        for (SudokuRow row : sudokuRows) {
            for (SudokuElement element : row.getSudokuElements()) {
                if (element.isUnsolvable()) {
                    System.out.println("\nThis element in unslovable: ");
                    element.printCoordinatePossibleValuesCurrentValue();
                    System.out.println("Size of poss vals: " + element.getPossibleValues().size() + "\n");
                    return true;
                }
            }
        }
        return false;
    }

    public SudokuElement getElementByCoordinates(Coordinate coordinate) throws SudokuUnsolvable {
        for (SudokuRow row : sudokuRows) {
            for (SudokuElement element : row.getSudokuElements()) {
                if (element.getCoordinate().getColumn() == coordinate.getColumn() &&
                        element.getCoordinate().getRow() == coordinate.getRow())
                    return element;
            }
        }
        throw new SudokuUnsolvable("Element " + coordinate + " could not be found");
    }

    private boolean isEmptySudEl(SudokuElement sudokuElement) {
        return sudokuElement.getValue() == SudokuElement.EMPTY;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        System.out.println("deepCopy()");

        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.sudokuRows = new ArrayList<>();

        for (SudokuRow row : sudokuRows) {
            SudokuRow clonedRow = new SudokuRow();
            clonedRow.getSudokuElements().clear();

            for (SudokuElement element : row.getSudokuElements()) {
                SudokuElement clonedElement = new SudokuElement();

                clonedElement.setValue(element.getValue());
                clonedElement.getPossibleValues().clear();
                clonedElement.getPossibleValues().addAll(new ArrayList<>(element.getPossibleValues()));
                clonedElement.setCoordinate(element.getCoordinate());

                clonedRow.getSudokuElements().add(clonedElement);
            }

            clonedBoard.sudokuRows.add(clonedRow);
        }
        System.out.println("Cloned board: \n" + clonedBoard);
        Display.allPossibleValues(clonedBoard);
        return clonedBoard;
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



