package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.SudokuUnsolvable;
import com.kodilla.sudoku.solve.Backtrack;
import com.kodilla.sudoku.solve.SaveLoad;
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
                System.out.println("Sudoku has been successfully solved!");
                Display.board(sudokuBoard);
                break;
            }

            System.out.println("resolveSudoku(): Backtrack size: " + backtracks.size());

            resolvingWithEliminator = solveByElimination(resolvingWithEliminator, sudokuBoard);


            System.out.println("\nsolveByElimination has finished, starting second part of resolveSudoku()\n"); // extract method
            if (sudokuBoard.isContradictory()) {

                System.out.println("STARTING sudokuBoard.isContradictory()");

                Display.board(sudokuBoard);
                SaveLoad.loadLastState(backtracks, sudokuBoard, this);

                System.out.println("FINISHED sudokuBoard.isContradictory()");

            } else if (!isSolved()) {

                System.out.println("STARTING resolveSudoku(): Sudoku !isSolved()");

                Solver.guessProcedure(backtracks, sudokuBoard, this);

                System.out.println("FINISHED resolveSudoku(): Sudoku !isSolved()");

            } else if (isSolved()) {
                System.out.println("Sudoku has been successfully solved!");
                Display.board(sudokuBoard);
                break;
            } else {
                System.out.println("Unexpected error occured while solving!");
                Display.board(sudokuBoard);
                break;
            }
        }
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
            System.out.println("Sudoku unsolved. Unsolved elements: " + unsolvedElements);
            return false;
        } else if (unsolvedElements == 0) {
            System.out.println("Sudoku solved, unsolved elements: " + unsolvedElements);
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
