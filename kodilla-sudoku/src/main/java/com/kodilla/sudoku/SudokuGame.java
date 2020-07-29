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
            if (SaveLoad.loadLastStateCounter == 2) break;

            System.out.println("resolveSudoku(): Backtrack size: " + backtracks.size());

            resolvingWithEliminator = solveByElimination(resolvingWithEliminator, sudokuBoard);

            System.out.println("\nsolveByElimination has finished, starting second part of resolveSudoku()\n");
            if (sudokuBoard.isContradictory()) {
                System.out.println("Board is contradictory...");
                Display.board(sudokuBoard);
                SaveLoad.loadLastState(backtracks, sudokuBoard, this);
            } else if (!isSolved()) {
                Solver.guessProcedure(backtracks, sudokuBoard, this);
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

    public boolean isSolved() {
        int unsolvedElements = 0;

        for (SudokuRow row : sudokuBoard.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                if (element.isEmpty()) {
                    unsolvedElements++;
                }
            }
        }

        if (unsolvedElements > 0) {
            System.out.println("Sudoku unsolved");
            return false;
        } else {
            System.out.println("Sudoku solved");
            return true;
        }
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }
}
