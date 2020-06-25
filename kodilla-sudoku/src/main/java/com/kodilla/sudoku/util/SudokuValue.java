package com.kodilla.sudoku.util;

public class SudokuValue {
    public static int ONE = 1;
    public static int TWO = 2;
    public static int THREE = 3;
    public static int FOUR = 4;
    public static int FIVE = 5;
    public static int SIX = 6;
    public static int SEVEN = 7;
    public static int EIGHT = 8;
    public static int NINE = 9;

    public static int setValue(String val) {
        switch (val) {
            case "1":
                return ONE;
            case "2":
                return TWO;
            case "3":
                return THREE;
            case "4":
                return FOUR;
            case "5":
                return FIVE;
            case "6":
                return SIX;
            case "7":
                return SEVEN;
            case "8":
                return EIGHT;
            case "9":
                return NINE;
            default:
                return 0;
        }
    }


}
