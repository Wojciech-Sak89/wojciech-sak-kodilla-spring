package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.SudokuUnsolvable;
import com.kodilla.sudoku.solve.Backtrack;
import com.kodilla.sudoku.solve.Load;
import com.kodilla.sudoku.solve.Solver;
import com.kodilla.sudoku.util.Display;

import java.util.ArrayDeque;

import static com.kodilla.sudoku.solve.Solver.solveByElimination;

public class SudokuGame {

    private SudokuBoard sudokuBoard;
    private final ArrayDeque<Backtrack> backtracks = new ArrayDeque<>();

    public SudokuGame(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void resolveSudoku() throws SudokuUnsolvable {
        boolean resolvingWithEliminator = true;

        while (true) {
            if (isSolved()) {
                solvedInfo("Sudoku has been successfully solved!");
                break;
            }

            resolvingWithEliminator = solveByElimination(resolvingWithEliminator, sudokuBoard);

            if (sudokuBoard.isContradictory()) {
                Load.loadLastState(backtracks, sudokuBoard, this);
            } else if (!isSolved()) {
                Solver.guessProcedure(backtracks, sudokuBoard, this);
            } else if (isSolved()) {
                solvedInfo("Sudoku has been successfully solved!");
                break;
            } else {
                System.out.println("Unexpected error!");
                Display.board(sudokuBoard);
                break;
            }
        }
    }

    private void solvedInfo(String s) {
        System.out.println(s);
        Display.board(sudokuBoard);
    }

    public boolean isSolved() throws SudokuUnsolvable {
        int unsolvedElements = 0;

        for (SudokuRow row : sudokuBoard.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                if (element.isEmpty()) {
                    unsolvedElements++;
                }
            }
        }

        if (unsolvedElements > 0) {
            return false;
        } else if (unsolvedElements == 0) {
            return true;
        } else {
            throw new SudokuUnsolvable("Error! Could not say if sudoku was solved or unsolved. " +
                    "Unsolved elements: " + unsolvedElements);
        }
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }
}
