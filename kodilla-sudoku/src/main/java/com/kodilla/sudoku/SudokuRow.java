package com.kodilla.sudoku;

import com.kodilla.sudoku.util.Initializer;

import java.util.List;

public class SudokuRow {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BRIGHT_MAGENTA = "\u001b[35;1m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_BRIGHT_GREEN  = "\u001B[92m";
    public static final String ANSI_BRIGHT_BLUE   = "\u001b[34;1m";
    public static final String ANSI_BRIGHT_BLACK   = "\u001b[30;1m";
    public static final String ANSI_WHITE = "\u001B[37m";


    private final List<SudokuElement> sudokuElements;

    public SudokuRow() {
        this.sudokuElements = Initializer.initRow();
    }

    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }

    @Override
    public String toString() {
        int counter = 0;
        StringBuilder s = new StringBuilder("||");

        for (SudokuElement sudokuElement : sudokuElements) {
            counter++;
            s
                    .append(sudokuElement.getCoordinate().getSection() % 2 == 0 ? ANSI_BRIGHT_BLUE : ANSI_BRIGHT_BLACK)
                    .append(sudokuElement.getValue())
                    .append(ANSI_RESET)
                    .append(counter == 3 || counter == 6 ? " ** " : "|");
        }

        s.append("|");

        return s.toString();
    }
}