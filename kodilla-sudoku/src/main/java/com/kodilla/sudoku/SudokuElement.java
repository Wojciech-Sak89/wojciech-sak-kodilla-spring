package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = 0;
    private List<Integer> possibleValues;
    private List<Integer> discardedValues = new ArrayList<>();
    private int value;

    public SudokuElement() {
        this.possibleValues = initPossibleValues();
        this.value = EMPTY;
    }

    private ArrayList<Integer> initPossibleValues() {
        ArrayList<Integer> standardPossibleValues = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            standardPossibleValues.add(i);
        }

        return standardPossibleValues;
    }

    public int getValue() {
        return value;
    }

    public boolean setValue(int value) {
        if (possibleValues.contains(value)) {
            this.value = value;
            int temp;
            discardedValues.add(value);

            for (int i = 0; i < possibleValues.size(); i++) {
                temp = possibleValues.get(i);
                if (value == temp) {
                    possibleValues.remove(i);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}