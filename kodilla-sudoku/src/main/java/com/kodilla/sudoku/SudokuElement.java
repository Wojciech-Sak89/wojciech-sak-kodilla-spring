package com.kodilla.sudoku;

import com.kodilla.sudoku.util.Coordinate;
import com.kodilla.sudoku.util.Initializer;

import java.util.List;

public class SudokuElement {
    public static int EMPTY = 0;
    private int value;
    private final List<Integer> possibleValues;
    private Coordinate coordinate;


    public SudokuElement() {
        this.possibleValues = Initializer.initPossibleValues();
        this.value = EMPTY;
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

    public boolean isEmpty() {
        return value == SudokuElement.EMPTY;
    }

    public boolean isUnsolvable() {
        return isEmpty() && possibleValues.size() == 1;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setUserValue(int value) {
        System.out.println("Setting user value...");
        if (possibleValues.contains(value)) {
            this.value = value;

            if (value != EMPTY)
                possibleValues.remove(Integer.valueOf(value));

            System.out.println("Value has been successfully set! Element: " + this);
        } else {
            System.out.println("Value (" + value + ") for element (" + coordinate + ") is invalid, " +
                    "try another number.");
        }
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void printCoordinatePossibleValuesCurrentValue() {
        System.out.println(coordinate + ", possibleVals: " + possibleValues + ", current value: " + value);
    }

    @Override
    public String toString() {
        return "SudokuElement{" +
                "value=" + value +
                ", possibleValues=" + possibleValues +
                ", coordinate=" + coordinate +
                '}';
    }
}