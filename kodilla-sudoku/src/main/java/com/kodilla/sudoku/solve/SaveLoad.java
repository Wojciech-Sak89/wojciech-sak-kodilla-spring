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

    public static void loadLastState(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game)
            throws SudokuUnsolvable {
        loadLastStateCounter++;
        preLoadInfo(sudokuBoard);

        SudokuElement sudokuElement;

        if (!backtracks.isEmpty()) {
            System.out.println("There are objects in backtracks!");

            Backtrack backtrack = backtracks.peek();

            sudokuBoard = backtrack.getSudokuBoard();

            sudokuElement = sudokuBoard.getElementByCoordinates(backtrack.getCoordinate());

            elementToChangeInfo(sudokuElement, backtrack);


            if (backtrackElementToAdjust_HasGuessNumAsPossibleNum(backtrack)){
                System.out.println("backtrackElementToAdjust_HasGuessNumAsPossibleNum(backtrack) = true");

                deleteInCurrentBoard(sudokuElement, backtrack);
                deleteInBacktrack(backtrack);
                realLoading(sudokuBoard, game);

                afterLoadingInfo(sudokuBoard, sudokuElement);
            } else {
                System.out.println("backtrackElementToAdjust_HasGuessNumAsPossibleNum(backtrack) = false");
                System.out.println("better load penultimate...");
                loadPenultimate(backtracks, sudokuBoard, game);
            }


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

    private static boolean backtrackElementToAdjust_HasGuessNumAsPossibleNum(Backtrack backtrack) throws SudokuUnsolvable {
        return backtrack.getSudokuBoard()
                .getElementByCoordinates(backtrack.getCoordinate())
                .getPossibleValues().contains(backtrack.getGuessNumber());
    }

    private static void elementToChangeInfo(SudokuElement sudokuElement, Backtrack backtrack) {
        System.out.println("\nloadLastState: backtrack.getGuessNumber() to remove from field possible nums:" + backtrack.getGuessNumber() +
                "\n possible nums: " + sudokuElement.getPossibleValues() + " coordinate: " + sudokuElement.getCoordinate());
    }

    private static void afterLoadingInfo(SudokuBoard sudokuBoard, SudokuElement sudokuElement) {
        System.out.println("Current state of board AFTER loading: ");
        Display.board(sudokuBoard);
        Display.allPossibleValues(sudokuBoard);

        adjustementInfo(sudokuBoard, sudokuElement);
    }

    private static void adjustementInfo(SudokuBoard sudokuBoard, SudokuElement sudokuElement) {
        System.out.println("Adjusted sudoku element: ");
        sudokuElement.printCoordinatePossibleValuesCurrentValue();

        System.out.println("Displaying all possible values AFTER loading (CHECK FOR CHANGES)\n");
        Display.allPossibleValues(sudokuBoard);
    }

    private static void realLoading(SudokuBoard sudokuBoard, SudokuGame game) {
        game.setSudokuBoard(sudokuBoard);
    }

    private static void deleteInBacktrack(Backtrack backtrack) throws SudokuUnsolvable {
        backtrack.getSudokuBoard()
                .getElementByCoordinates(backtrack.getCoordinate())
                .getPossibleValues()
                .remove(Integer.valueOf(backtrack.getGuessNumber()));
    }

    private static void deleteInCurrentBoard(SudokuElement sudokuElement, Backtrack backtrack) {
        sudokuElement.getPossibleValues().remove(Integer.valueOf(backtrack.getGuessNumber()));
    }

    private static void preLoadInfo(SudokuBoard sudokuBoard) {
        System.out.println("\nSTARTING loadLastState: Displaying all possible values BEFORE loading");
        Display.allPossibleValues(sudokuBoard);


        System.out.println("\nloadLastState()");

        System.out.println("Current state of board BEFORE loading: ");
        Display.board(sudokuBoard);
        Display.allPossibleValues(sudokuBoard);
    }

    public static void loadPenultimate(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game) throws SudokuUnsolvable {
        loadPenultimateCounter++;

        System.out.println("STARTING loadPenultimate()");
        backtracks.pop();
        loadLastState(backtracks, sudokuBoard, game);

        System.out.println("FINISHED loadPenultimate()");
    }

}
