package com.kodilla.sudoku.solve;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.SudokuElement;
import com.kodilla.sudoku.SudokuGame;
import com.kodilla.sudoku.exceptions.SudokuUnsolvable;

import java.util.ArrayDeque;

public class Load {

    public static void loadLastState(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game)
            throws SudokuUnsolvable {
        SudokuElement sudokuElement;

        if (!backtracks.isEmpty()) {
            Backtrack backtrack = backtracks.peek();

            sudokuBoard = backtrack.getSudokuBoard();
            sudokuElement = sudokuBoard.getElementByCoordinates(backtrack.getCoordinate());

            if (backtrackElementToAdjust_HasGuessNumAsPossibleNum(backtrack)){
                deleteInCurrentBoard(sudokuElement, backtrack);
                deleteInBacktrack(backtrack);
                realLoading(sudokuBoard, game);
            } else {
                loadPenultimate(backtracks, sudokuBoard, game);
            }

            if (sudokuElement.getPossibleValues().size() == 1) {
                loadPenultimate(backtracks, sudokuBoard, game);
            } else {
                backtrack.setSudokuBoard(sudokuBoard);
            }
        } else {
            throw new SudokuUnsolvable("Entered SUDOKU is invalid. Sudoku unsolvable");
        }
    }

    private static void deleteInCurrentBoard(SudokuElement sudokuElement, Backtrack backtrack) {
        sudokuElement.getPossibleValues().remove(Integer.valueOf(backtrack.getGuessNumber()));
    }

    private static void deleteInBacktrack(Backtrack backtrack) throws SudokuUnsolvable {
        backtrack.getSudokuBoard()
                .getElementByCoordinates(backtrack.getCoordinate())
                .getPossibleValues()
                .remove(Integer.valueOf(backtrack.getGuessNumber()));
    }

    private static boolean backtrackElementToAdjust_HasGuessNumAsPossibleNum(Backtrack backtrack) throws SudokuUnsolvable {
        return backtrack.getSudokuBoard()
                .getElementByCoordinates(backtrack.getCoordinate())
                .getPossibleValues().contains(backtrack.getGuessNumber());
    }

    private static void realLoading(SudokuBoard sudokuBoard, SudokuGame game) {
        game.setSudokuBoard(sudokuBoard);
    }

    public static void loadPenultimate(ArrayDeque<Backtrack> backtracks, SudokuBoard sudokuBoard, SudokuGame game) throws SudokuUnsolvable {
        backtracks.pop();
        loadLastState(backtracks, sudokuBoard, game);
    }

}
