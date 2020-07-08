package com.kodilla.sudoku;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userRequest;
        SudokuGame theGame = new SudokuGame(new SudokuBoard());
        boolean gameFinished = false;

        theGame.displayBoard();

            while (!gameFinished) {
                System.out.println("Please insert some values. Format: \"[column 1-9],[row 1-9],[value 1-9]\"" +
                        "\nEnter SUDOKU if you want to finish");
                userRequest = scanner.nextLine();

                if (userRequest.equals("SUDOKU")) {
                    gameFinished = true;
                    theGame.displayBoard();
                } else {
                    theGame.userSetValue(userRequest);
                    theGame.displayBoard();
                    theGame.printTestPossibleVals();
                }

//                gameFinished = theGame.resolveSudoku();
            }



    }
}
