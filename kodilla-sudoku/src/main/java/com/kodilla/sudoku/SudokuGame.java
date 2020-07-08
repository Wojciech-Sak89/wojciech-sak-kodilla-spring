package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.SudokuUnsolvable;
import com.kodilla.sudoku.util.SudokuTabulation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuGame {

    private final SudokuBoard sudokuBoard;

    public SudokuGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean resolveSudoku() {
        return false;
    }

    private boolean setBoardValue(int sudokuColumn, int sudokuRow, Integer sudokuValue) {
        SudokuElement sudokuElement = sudokuBoard
                .getSudokuRows().get(sudokuRow)
                .getSudokuElements().get(sudokuColumn);

        if (sudokuElement.getValue() != SudokuElement.EMPTY &&
                sudokuValue != SudokuElement.EMPTY) {

            System.out.println("Error! This field already has value! Please choose another area.");
            return false;
        }

        sudokuElement.setValue(sudokuValue);

        try {
            updateBoard();
        } catch (SudokuUnsolvable e) {
            System.out.println("Unable to update board with current values in board: " + e.getMessage());
        }

        return true;
    }

    private void updateBoard() throws SudokuUnsolvable {
        Set<Integer> valuesToDiscard = new HashSet<>();

        List<Integer> rowValuesToDiscard;
        List<Integer> columnValuesToDiscard;
        List<Integer> sectionValuesToDiscard;

        int elementRow;
        int elementColumn;
        int elementSection;

        for (SudokuRow row : sudokuBoard.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                elementRow = element.getCoordinate().getRow();
                elementColumn = element.getCoordinate().getColumn();
                elementSection = element.getCoordinate().getSection();

                if (element.getValue() == SudokuElement.EMPTY) {


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

                setBoardValFromElementLastPossibleValue(
                        elementRow, elementColumn, element);

            }
        }
    }

    private void setBoardValFromElementLastPossibleValue(int elementRow, int elementColumn, SudokuElement element) throws SudokuUnsolvable {
        boolean isSet;
        if (element.getPossibleValues().size() == 2) {
            isSet = setBoardValue(SudokuTabulation.setColumn(elementColumn),
                    SudokuTabulation.setRow(elementRow),
                    element.getPossibleValues().get(1));

            if (!isSet) {
                throw new SudokuUnsolvable();
            }
        }


    }

    public void userSetValue(String userInput) {
        String[] input = userInput.split(","); // add format error

        setBoardValue(
                SudokuTabulation.setColumn(input[0]),
                SudokuTabulation.setRow(input[1]),
                Integer.parseInt(input[2]));

        if (!sudokuBoard.isValid()) {
            System.out.println("Error! Invalid input, Sudoku unsupported value for row/column/section!");
            discardUserInput(input);
        }

    }

    private void discardUserInput(String[] input) {
        setBoardValue(
                SudokuTabulation.setColumn(input[0]),
                SudokuTabulation.setRow(input[1]),
                SudokuElement.EMPTY);

        putBackPossibleVal(input);
    }

    private void putBackPossibleVal(String[] input) {
        sudokuBoard.getSudokuRows().get(SudokuTabulation.setColumn(input[0]))
                .getSudokuElements().get(SudokuTabulation.setRow(input[1]))
                .getPossibleValues()
                .add(Integer.parseInt(input[2]));
    }

    public void displayBoard() {
        System.out.println(sudokuBoard);
    }

    public void printTestPossibleVals() {
        List<Integer> listOfRemainingPossVals =
                sudokuBoard.getSudokuRows().get(0).getSudokuElements().get(2).getPossibleValues();

        System.out.println("listOfRemainingPossVals element 1,3: " + listOfRemainingPossVals);
    }
}
