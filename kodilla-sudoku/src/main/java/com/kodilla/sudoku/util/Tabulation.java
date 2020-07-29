package com.kodilla.sudoku.util;

public class Tabulation {

    public static int calculateRow(String row) {
        return Integer.parseInt(row) - 1;
    }

    public static int calculateColumn(String column) {
        return Integer.parseInt(column) - 1;
    }

    public static int calculateRow(int row) {
       return row - 1;
    }

    public static int calculateColumn(int column) {
       return column - 1;
    }

    public static int rowRawVal(int row) {
       return row;
    }

    public static int columnRawVal(int column) {
        return column;
    }
}
