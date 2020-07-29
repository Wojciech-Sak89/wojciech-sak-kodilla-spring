package com.kodilla.sudoku.util;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuRow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardManipulater {

    public static void userSetValue(String userInput, SudokuBoard sudokuBoard) {
        String[] input = userInput.split(","); // add format error + regEx

        setBoardValue(
                Tabulation.calculateColumn(input[0]),
                Tabulation.calculateRow(input[1]),
                Integer.parseInt(input[2]),
                sudokuBoard);

        if (!sudokuBoard.isValid()) {
            System.out.println("Error! Invalid input, Sudoku unsupported value for row/column/section!");
            discardUserInput(input, sudokuBoard);
        }
    }

    public static boolean setBoardValue(int sudokuColumn, int sudokuRow, Integer sudokuValue, SudokuBoard sudokuBoard) {
        SudokuElement sudokuElement = getSudokuElement(sudokuColumn, sudokuRow, sudokuBoard);

        System.out.println("setBoardValue(): Trying to finally set the value: " + sudokuValue + " for " + sudokuElement);
        if (isOccupied(sudokuValue, sudokuElement)) return false;

        sudokuElement.setUserValue(sudokuValue);
        updateBoard(sudokuBoard);
        return true;
    }

    private static void discardUserInput(String[] input, SudokuBoard sudokuBoard) {
        setBoardValue(
                Tabulation.calculateColumn(input[0]),
                Tabulation.calculateRow(input[1]),
                SudokuElement.EMPTY,
                sudokuBoard);

        putBackPossibleVal_ToElement(input, sudokuBoard);
    }

    private static void putBackPossibleVal_ToElement(String[] input, SudokuBoard sudokuBoard) {
        sudokuBoard.getSudokuRows().get(Tabulation.calculateColumn(input[0]))
                .getSudokuElements().get(Tabulation.calculateRow(input[1]))
                .getPossibleValues()
                .add(Integer.parseInt(input[2]));
    }

    public static SudokuElement getSudokuElement(int sudokuColumn, int sudokuRow, SudokuBoard sudokuBoard) {
        return sudokuBoard
                .getSudokuRows().get(sudokuRow)
                .getSudokuElements().get(sudokuColumn);
    }

    private static boolean isOccupied(Integer sudokuValue, SudokuElement sudokuElement) { // should be in Element Class
        if (sudokuElement.getValue() != SudokuElement.EMPTY &&
                sudokuValue != SudokuElement.EMPTY) {

            System.out.println("Error! This field already has value! Please choose another area.");
            return true;
        }
        return false;
    }

    private static void updateBoard(SudokuBoard sudokuBoard) {
        Set<Integer> valuesToDiscard = new HashSet<>();
        int elementRow;
        int elementColumn;
        int elementSection;

        for (SudokuRow row : sudokuBoard.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                elementRow = element.getCoordinate().getRow();
                elementColumn = element.getCoordinate().getColumn();
                elementSection = element.getCoordinate().getSection();

                removeElementsPossibleValues_ThatWereChecked(
                        valuesToDiscard, elementRow, elementColumn, elementSection, element, sudokuBoard);
            }
        }
    }

    private static void removeElementsPossibleValues_ThatWereChecked(Set<Integer> valuesToDiscard,
                                                              int elementRow, int elementColumn, int elementSection,
                                                              SudokuElement element,
                                                              SudokuBoard sudokuBoard) {
        List<Integer> rowValuesToDiscard;
        List<Integer> columnValuesToDiscard;
        List<Integer> sectionValuesToDiscard;
        if (element.isEmpty()) {

            rowValuesToDiscard = sudokuBoard.getRowValues(elementRow);
            columnValuesToDiscard = sudokuBoard.getColumnValues(elementColumn);
            sectionValuesToDiscard = sudokuBoard.getSectionValues(elementSection);

            valuesToDiscard.addAll(rowValuesToDiscard);
            valuesToDiscard.addAll(columnValuesToDiscard);
            valuesToDiscard.addAll(sectionValuesToDiscard);

            for (int value : valuesToDiscard) {
                element.getPossibleValues().remove(Integer.valueOf(value));
            }
            valuesToDiscard.clear();
        }
    }
}
