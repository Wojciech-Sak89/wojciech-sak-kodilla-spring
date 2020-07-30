package com.kodilla.sudoku.solve;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuGame;
import com.kodilla.sudoku.SudokuRow;
import com.kodilla.sudoku.exceptions.SudokuUnsolvable;
import com.kodilla.sudoku.util.BoardManipulater;
import com.kodilla.sudoku.util.Display;
import com.kodilla.sudoku.util.Tabulation;

import java.util.ArrayDeque;

public class Solver {

    public static boolean solveByElimination(boolean resolvingWithEliminator, SudokuBoard sudokuBoard) throws SudokuUnsolvable {
        System.out.println("\nStart solveByElimination()");

        int eliminatorCounter;
        int elementRow;
        int elementColumn;
        eliminatorCounter = 0;

        for (SudokuRow row : sudokuBoard.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                elementRow = element.getCoordinate().getRow();
                elementColumn = element.getCoordinate().getColumn();

                if(element.isEmpty()) {
                    System.out.println("Element is empty, eliminator will try put some value to element: " + element);
                    resolvingWithEliminator = Solver.setBoardValFromElementLastPossibleValue(
                            elementRow, elementColumn, element, sudokuBoard);
                }

                if (resolvingWithEliminator) {
                    System.out.println("\nresolvingWithEliminator has made some changes: \n");
                    Display.board(sudokuBoard);
                    Display.allPossibleValues(sudokuBoard);
                    eliminatorCounter++;
                    System.out.println("Eliminator counter" + eliminatorCounter);
                }
            }
        }

        System.out.println("Board after elimination: ");
        Display.board(sudokuBoard);
        Display.allPossibleValues(sudokuBoard);

        if (eliminatorCounter == 0) System.out.println("Eliminator did nothing");
        return resolvingWithEliminator;
    }

    public static boolean setBoardValFromElementLastPossibleValue(int elementRow, int elementColumn, SudokuElement element, SudokuBoard sudokuBoard) {
        System.out.println("setBoardValFromElementLastPossibleValue() starts");
        boolean isSet;
        boolean elementResolved = false;
        if (element.getPossibleValues().size() == 2) {
            System.out.println("Elements possVals.size == 2, so it will take last possVal apart from \"0\" and will put it into elemnts value for element: " + element);
            isSet = BoardManipulater.setBoardValue(Tabulation.calculateColumn(elementColumn),
                    Tabulation.calculateRow(elementRow),
                    element.getPossibleValues().get(1),
                    sudokuBoard);

            if (!isSet) {
                System.out.println("ERROR! Element that cannot be set: " + element.getCoordinate() +
                        "\nLast possible value for this element: \"" + element.getPossibleValues().get(1) +
                        "\" could not be set, has been used in some other element in this section/column/raw. ");
            }
            elementResolved = true;
        }
        return elementResolved;
    }

    public static void guessProcedure(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game) throws SudokuUnsolvable {
        System.out.println("\nSTARTING guessing procedure...\n");
        System.out.println("State of board before guessing");
        Display.board(sudokuBoard);

        SudokuElement element = getFirstEmptyElement(backtracks, sudokuBoard, game);
        boolean wasSet = true;

        int possibleVal = element.getPossibleValues().get(1);
        System.out.println("Value of guess: " + possibleVal +
                ", coordinates: " + element.getCoordinate() +
                ", possible values" + element.getPossibleValues());

        SaveLoad.saveCurrentState(element, possibleVal, backtracks, sudokuBoard);

        if (element.isEmpty()) {
            wasSet = BoardManipulater.setBoardValue(
                    Tabulation.calculateColumn(element.getCoordinate().getColumn()),
                    Tabulation.calculateRow(element.getCoordinate().getRow()),
                    possibleVal,
                    sudokuBoard);
        }

        if (!wasSet) {
            SaveLoad.loadLastState(backtracks, sudokuBoard, game);
        }
        System.out.println("\nFINISHED guessing procedure");
    }


    private static SudokuElement getFirstEmptyElement(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game) throws SudokuUnsolvable {
        System.out.println("STARTING getFirstEmptyElement()\n");
        for (SudokuRow row : sudokuBoard.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                if (element.isEmpty()) {
                    System.out.println("First empty element: " +
                            element.getCoordinate() + element.getPossibleValues());
                    System.out.println("FINISHED getFirstEmptyElement(). First empty element has been found: " + element);
                    return element;
                }
            }
        }
        System.out.println("\nThere are no empty elements! Trying to delete last backtrack, loading previous.\n");

        if (backtracks.size() >= 2) {
            SaveLoad.loadPenultimate(backtracks, sudokuBoard, game);
        } else {
            throw new SudokuUnsolvable("\nThere are no backtrack objects left!\n");
        }

        System.out.println("FINISHED getFirstEmptyElement() with new SudokuElement()\n");
        return new SudokuElement();
    }
}
