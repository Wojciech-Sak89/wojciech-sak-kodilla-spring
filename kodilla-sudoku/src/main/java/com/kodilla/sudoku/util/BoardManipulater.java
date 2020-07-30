package com.kodilla.sudoku.util;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuRow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardManipulater {

    public static void userSetValue(String userInput, SudokuBoard sudokuBoard) {
        System.out.println("STARTING userSetValue()");

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
        System.out.println("FINISHED userSetValue()");
    }

    public static boolean setBoardValue(int sudokuColumn, int sudokuRow, Integer sudokuValue, SudokuBoard sudokuBoard) {
        System.out.println("STARTING setBoardValue()");

        SudokuElement sudokuElement = getSudokuElement(sudokuColumn, sudokuRow, sudokuBoard);

        System.out.println("setBoardValue(): Trying to finally set the value: " + sudokuValue + " for " + sudokuElement);
        if (isOccupied(sudokuValue, sudokuElement)) {
            System.out.println("FINISHED userSetValue(): field isOccupied");
            return false;
        }

        sudokuElement.setUserValue(sudokuValue);
        updateBoard(sudokuBoard);
        System.out.println("FINISHED userSetValue()");
        return true;
    }

    private static void discardUserInput(String[] input, SudokuBoard sudokuBoard) {
        System.out.println("STARTING discardUserInput()");
        setBoardValue(
                Tabulation.calculateColumn(input[0]),
                Tabulation.calculateRow(input[1]),
                SudokuElement.EMPTY,
                sudokuBoard);

        putBackPossibleVal_ToElement(input, sudokuBoard);
        System.out.println("FINISHED discardUserInput()");
    }

    private static void putBackPossibleVal_ToElement(String[] input, SudokuBoard sudokuBoard) {
        System.out.println("STARTING putBackPossibleVal_ToElement");

        sudokuBoard.getSudokuRows().get(Tabulation.calculateColumn(input[0]))
                .getSudokuElements().get(Tabulation.calculateRow(input[1]))
                .getPossibleValues()
                .add(Integer.parseInt(input[2]));

        System.out.println("FINISHED putBackPossibleVal_ToElement");
    }

    public static SudokuElement getSudokuElement(int sudokuColumn, int sudokuRow, SudokuBoard sudokuBoard) {
        System.out.println("STARTING and FINISHING :) getSudokuElement()");

        return sudokuBoard
                .getSudokuRows().get(sudokuRow)
                .getSudokuElements().get(sudokuColumn);
    }

    private static boolean isOccupied(Integer sudokuValue, SudokuElement sudokuElement) { // should be in Element Class
        System.out.println("STARTING isOccupied");
        if (sudokuElement.getValue() != SudokuElement.EMPTY &&
                sudokuValue != SudokuElement.EMPTY) {

            System.out.println("Error! This field already has value! Please choose another area.");
            return true;
        }
        System.out.println("FINISHED: field is not occupied!");
        return false;
    }

    private static void updateBoard(SudokuBoard sudokuBoard) {
        System.out.println("STARTING updateBoard()");

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

        System.out.println("FINISHED updateBoard()");
    }

    private static void removeElementsPossibleValues_ThatWereChecked(Set<Integer> valuesToDiscard,
                                                              int elementRow, int elementColumn, int elementSection,
                                                              SudokuElement element,
                                                              SudokuBoard sudokuBoard) {
        System.out.println("STARTING removeElementsPossibleValues_ThatWereChecked");

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

        System.out.println("FINISHED removeElementsPossibleValues_ThatWereChecked");
    }
}
