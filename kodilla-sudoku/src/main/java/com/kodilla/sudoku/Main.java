package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.SudokuUnsolvable;
import com.kodilla.sudoku.testing.Filler;
import com.kodilla.sudoku.util.BoardManipulater;
import com.kodilla.sudoku.util.Display;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SudokuUnsolvable, IOException, CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        String userRequest;
        SudokuGame theGame = new SudokuGame(new SudokuBoard());
        SudokuBoard board = theGame.getSudokuBoard();
        boolean gameFinished = false;

        Display.board(board);

        while (!gameFinished) {
            System.out.println("Please insert some values. " +
                    "\nFormat: \"[column 1-9],[row 1-9],[value 1-9]\", e.g. \"3,8,1\" sets in column=3, row=8, value=1" +
                    "\nEnter SUDOKU if you want to solve yours entered sudoku");
            userRequest = scanner.nextLine();

            switch (userRequest) {
                case "SUDOKU":
                    gameFinished = true;
                    theGame.resolveSudoku();
                    break;
                case "TEST1":
                    Filler.solvableWith_SimpleElimination(board);
                    Display.board(board);
                    break;
                case "TEST2":
                    Filler.solved(board);
                    Display.board(board);
                    break;
                case "TEST3":
                    Filler.solvableWith_LittleGuessing(board);
                    Display.board(board);
                    break;
                case "TEST4":
                    Filler.solvableWith_LotsOfGuessing(board);
                    Display.board(board);
                    break;
                default:
                    if (!userRequest.matches("[0-9],[0-9],[0-9]")) {
                        System.out.println("Invalid input!");
                        continue;
                    }
                    BoardManipulater.userSetValue(userRequest, board);
                    Display.board(board);
                    break;
            }
        }
    }
}
