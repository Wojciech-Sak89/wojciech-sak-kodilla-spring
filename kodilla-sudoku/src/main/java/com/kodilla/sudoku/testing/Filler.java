package com.kodilla.sudoku.testing;

import com.kodilla.sudoku.SudokuBoard;
import com.kodilla.sudoku.util.BoardManipulater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Filler {
    public static void solved(SudokuBoard sudokuBoard) throws IOException {
        File file = new File("kodilla-sudoku\\src\\main\\resources\\TestingData\\solved.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String input;
        while ((input = br.readLine()) != null)
            BoardManipulater.userSetValue(input, sudokuBoard);
    }

    public static void solvableWith_SimpleElimination(SudokuBoard sudokuBoard) throws IOException {
        File file = new File("kodilla-sudoku\\src\\main\\resources\\TestingData\\solvable_simpleElimination.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String input;
        while ((input = br.readLine()) != null)
            BoardManipulater.userSetValue(input, sudokuBoard);
    }

    public static void solvableWith_LittleGuessing(SudokuBoard sudokuBoard) throws IOException {
        File file = new File("kodilla-sudoku\\src\\main\\resources\\TestingData\\solvable_withLittleGuessing.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String input;
        while ((input = br.readLine()) != null)
            BoardManipulater.userSetValue(input, sudokuBoard);
    }

    public static void solvableWith_LotsOfGuessing(SudokuBoard sudokuBoard) throws IOException {
        File file = new File("kodilla-sudoku\\src\\main\\resources\\TestingData\\solvable_withLotsOfGuessing.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String input;
        while ((input = br.readLine()) != null)
            BoardManipulater.userSetValue(input, sudokuBoard);
    }
}
