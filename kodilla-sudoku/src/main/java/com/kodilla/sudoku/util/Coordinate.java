package com.kodilla.sudoku.util;

public class Coordinate {
    private int column;
    private int row;
    private int section;

    public Coordinate(int column, int row) {
        this.column = column;
        this.row = row;
        this.section = 0;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getSection() {
        return section;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSection(int section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (column != that.column) return false;
        if (row != that.row) return false;
        return section == that.section;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        result = 31 * result + section;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "column=" + column +
                ", row=" + row +
                ", section=" + section +
                '}';
    }
}
