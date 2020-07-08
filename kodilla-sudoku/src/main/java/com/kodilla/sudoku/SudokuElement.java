package com.kodilla.sudoku;

import com.kodilla.sudoku.util.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = 0;
    private int value;
    private final List<Integer> possibleValues;
    private Coordinate coordinate;


    public SudokuElement() {
        this.possibleValues = initPossibleValues();
        this.value = EMPTY;
    }

    private ArrayList<Integer> initPossibleValues() {
        ArrayList<Integer> standardPossibleValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            standardPossibleValues.add(i);
        }

        return standardPossibleValues;
    }

    public int getValue() {
        return value;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(int value) {
        if (possibleValues.contains(value)) {
            this.value = value;

            if (value != EMPTY)
            possibleValues.remove(Integer.valueOf(value));

        }
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}