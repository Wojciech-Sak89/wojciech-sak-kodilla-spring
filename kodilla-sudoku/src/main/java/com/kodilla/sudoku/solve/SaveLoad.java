package com.kodilla.sudoku.solve;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuGame;
import com.kodilla.sudoku.exceptions.SudokuUnsolvable;
import com.kodilla.sudoku.util.Display;

import java.util.ArrayDeque;

public class SaveLoad {

    public static int loadLastStateCounter = 0;
    public static int loadPenultimateCounter = 0;

    public static void saveCurrentState(SudokuElement element, int possibleVal, ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard) {

        System.out.println("Saving current state...");

        try {
            backtracks.push(new Backtrack(sudokuBoard.deepCopy(), element.getCoordinate(), possibleVal));
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadLastState(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game) throws SudokuUnsolvable {
        System.out.println("\n loadLastState: Displaying all possible values BEFORE loading");
        Display.allPossibleValues(sudokuBoard);

        loadLastStateCounter++;

        System.out.println("\nloadLastState()");

        System.out.println("Current state of board BEFORE loading: ");
        Display.board(sudokuBoard);
        Display.allPossibleValues(sudokuBoard);

        SudokuElement sudokuElement;

        if (!backtracks.isEmpty()) {
            System.out.println("There are objects in backtracks!");

            Backtrack backtrack = backtracks.peek();

            sudokuBoard = backtrack.getSudokuBoard();

            System.out.println("Current state of board AFTER loading: ");
            Display.board(sudokuBoard);
            Display.allPossibleValues(sudokuBoard);

            sudokuElement = sudokuBoard.getElementByCoordinates(backtrack.getCoordinate());

            System.out.println("\nloadLastState: backtrack.getGuessNumber() to remove from field possible nums:" + backtrack.getGuessNumber() +
                    "\n possible nums: " + sudokuElement.getPossibleValues() + " coordinate: " + sudokuElement.getCoordinate());

            // delete in current board
            sudokuElement.getPossibleValues().remove(Integer.valueOf(backtrack.getGuessNumber()));
            // delete also in backtrack!
            backtrack.getSudokuBoard().getElementByCoordinates(backtrack.getCoordinate()).getPossibleValues().remove(Integer.valueOf(backtrack.getGuessNumber()));

            System.out.println("Adjusted sudoku element: ");
            sudokuElement.printCoordinatePossibleValuesCurrentValue();

            System.out.println("Displaying all possible values AFTER loading (CHECK FOR CHANGES)\n");
            Display.allPossibleValues(sudokuBoard);

            // real loading
            game.setSudokuBoard(sudokuBoard);

            if (sudokuElement.getPossibleValues().size() == 1) {
                loadPenultimate(backtracks, sudokuBoard, game);
            } else {
                System.out.println("\nbacktrack state after eliminating val from possVals");
                Display.allPossibleValues(sudokuBoard);
                backtrack.setSudokuBoard(sudokuBoard);
            }
        } else {
            throw new SudokuUnsolvable("Entered SUDOKU is invalid. Sudoku unsolvable");
        }

        System.out.println("loadLastState has finished\n");
    }

    public static void loadPenultimate(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game) throws SudokuUnsolvable {
        loadPenultimateCounter++;

        System.out.println("loadPenultimate()");
        backtracks.pop();
        loadLastState(backtracks, sudokuBoard, game);
    }

}
