package com.kodilla.sudoku.solve;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuGame;
import com.kodilla.sudoku.SudokuRow;
import com.kodilla.sudoku.exceptions.SudokuUnsolvable;
import com.kodilla.sudoku.util.BoardManipulater;
import com.kodilla.sudoku.util.Tabulation;

import java.util.ArrayDeque;

public class Solver {

    public static boolean solveByElimination(boolean resolvingWithEliminator, SudokuBoard sudokuBoard) {
        int elementRow;
        int elementColumn;

        for (SudokuRow row : sudokuBoard.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                elementRow = element.getCoordinate().getRow();
                elementColumn = element.getCoordinate().getColumn();

                if (element.isEmpty()) {
                    resolvingWithEliminator = Solver.setBoardValFromElementLastPossibleValue(
                            elementRow, elementColumn, element, sudokuBoard);
                }
            }
        }
        return resolvingWithEliminator;
    }

    public static boolean setBoardValFromElementLastPossibleValue(int elementRow, int elementColumn, SudokuElement element, SudokuBoard sudokuBoard) {
        boolean elementResolved = false;
        if (element.getPossibleValues().size() == 2) {
            BoardManipulater.setBoardValue(Tabulation.calculateColumn(elementColumn),
                    Tabulation.calculateRow(elementRow),
                    element.getPossibleValues().get(1),
                    sudokuBoard);

            elementResolved = true;
        }
        return elementResolved;
    }

    public static void guessProcedure(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game) throws SudokuUnsolvable {
        SudokuElement element = getFirstEmptyElement(backtracks, sudokuBoard, game);
        boolean wasSet = true;

        int possibleVal = element.getPossibleValues().get(1);

        Save.currentState(element, possibleVal, backtracks, sudokuBoard);

        if (element.isEmpty()) {
            wasSet = BoardManipulater.setBoardValue(
                    Tabulation.calculateColumn(element.getCoordinate().getColumn()),
                    Tabulation.calculateRow(element.getCoordinate().getRow()),
                    possibleVal,
                    sudokuBoard);
        }

        if (!wasSet) {
            Load.loadLastState(backtracks, sudokuBoard, game);
        }
    }


    private static SudokuElement getFirstEmptyElement(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game) throws SudokuUnsolvable {
        for (SudokuRow row : sudokuBoard.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                if (element.isEmpty()) {
                    return element;
                }
            }
        }

        if (backtracks.size() >= 2) {
            Load.loadPenultimate(backtracks, sudokuBoard, game);
        } else {
            throw new SudokuUnsolvable("\nThere are no backtrack objects left!\n");
        }
        return new SudokuElement();
    }
}
