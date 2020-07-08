package com.kodilla.sudoku.util;

public class SudokuTabulation {

    public static int ROW_ONE = 0;
    public static int ROW_TWO = 1;
    public static int ROW_THREE = 2;
    public static int ROW_FOUR = 3;
    public static int ROW_FIVE = 4;
    public static int ROW_SIX = 5;
    public static int ROW_SEVEN = 6;
    public static int ROW_EIGHT = 7;
    public static int ROW_NINE = 8;

    public static int COLUMN_ONE = 0;
    public static int COLUMN_TWO = 1;
    public static int COLUMN_THREE = 2;
    public static int COLUMN_FOUR = 3;
    public static int COLUMN_FIVE = 4;
    public static int COLUMN_SIX = 5;
    public static int COLUMN_SEVEN = 6;
    public static int COLUMN_EIGHT = 7;
    public static int COLUMN_NINE = 8;

    public static int setRow(String row) {
        switch (row) {
            case "1":
                return ROW_ONE;
            case "2":
                return ROW_TWO;
            case "3":
                return ROW_THREE;
            case "4":
                return ROW_FOUR;
            case "5":
                return ROW_FIVE;
            case "6":
                return ROW_SIX;
            case "7":
                return ROW_SEVEN;
            case "8":
                return ROW_EIGHT;
            case "9":
                return ROW_NINE;
            default:
                return 0;
        }
    }

    public static int setColumn(String column) {
        switch (column) {
            case "1":
                return COLUMN_ONE;
            case "2":
                return COLUMN_TWO;
            case "3":
                return COLUMN_THREE;
            case "4":
                return COLUMN_FOUR;
            case "5":
                return COLUMN_FIVE;
            case "6":
                return COLUMN_SIX;
            case "7":
                return COLUMN_SEVEN;
            case "8":
                return COLUMN_EIGHT;
            case "9":
                return COLUMN_NINE;
            default:
                return 0;
        }
    }

    public static int setRow(int row) {
        switch (row) {
            case 1:
                return ROW_ONE;
            case 2:
                return ROW_TWO;
            case 3:
                return ROW_THREE;
            case 4:
                return ROW_FOUR;
            case 5:
                return ROW_FIVE;
            case 6:
                return ROW_SIX;
            case 7:
                return ROW_SEVEN;
            case 8:
                return ROW_EIGHT;
            case 9:
                return ROW_NINE;
            default:
                return 0;
        }
    }

    public static int setColumn(int column) {
        switch (column) {
            case 1:
                return COLUMN_ONE;
            case 2:
                return COLUMN_TWO;
            case 3:
                return COLUMN_THREE;
            case 4:
                return COLUMN_FOUR;
            case 5:
                return COLUMN_FIVE;
            case 6:
                return COLUMN_SIX;
            case 7:
                return COLUMN_SEVEN;
            case 8:
                return COLUMN_EIGHT;
            case 9:
                return COLUMN_NINE;
            default:
                return 0;
        }
    }

    public static int setRow_RawVal(int row) {
        switch (row) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            default:
                return 0;
        }
    }

    public static int setColumn_RawVal(int column) {
        switch (column) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            default:
                return 0;
        }
    }
}
