package com.kodilla.sudoku.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sections {
    private final Map<Integer, List<Coordinate>> sections = new HashMap<>();

    private final List<Coordinate> section1 = new ArrayList<>();
    private final List<Coordinate> section2 = new ArrayList<>();
    private final List<Coordinate> section3 = new ArrayList<>();
    private final List<Coordinate> section4 = new ArrayList<>();
    private final List<Coordinate> section5 = new ArrayList<>();
    private final List<Coordinate> section6 = new ArrayList<>();
    private final List<Coordinate> section7 = new ArrayList<>();
    private final List<Coordinate> section8 = new ArrayList<>();
    private final List<Coordinate> section9 = new ArrayList<>();

    public int determinateSection(Coordinate coordinate) {
        if (getSection1().contains(coordinate)) {
            return 1;
        } if (getSection2().contains(coordinate)) {
            return 2;
        } if (getSection3().contains(coordinate)) {
            return 3;
        } if (getSection4().contains(coordinate)) {
            return 4;
        } if (getSection5().contains(coordinate)) {
            return 5;
        } if (getSection6().contains(coordinate)) {
            return 6;
        } if (getSection7().contains(coordinate)) {
            return 7;
        } if (getSection8().contains(coordinate)) {
            return 8;
        } if (getSection9().contains(coordinate)) {
            return 9;
        }
        return -1;
    }

    public List<Coordinate> getSectionCoordinates(int i) {
        sections.put(1, getSection1());
        sections.put(2, getSection2());
        sections.put(3, getSection3());
        sections.put(4, getSection4());
        sections.put(5, getSection5());
        sections.put(6, getSection6());
        sections.put(7, getSection7());
        sections.put(8, getSection8());
        sections.put(9, getSection9());

        return sections.get(i);
    }

    private List<Coordinate> getSection1() {
        section1.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(1)));
        section1.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(1)));
        section1.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(1)));

        section1.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(2)));
        section1.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(2)));
        section1.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(2)));

        section1.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(3)));
        section1.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(3)));
        section1.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(3)));

        return section1;
    }

    private List<Coordinate> getSection2() {
        section2.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(1)));
        section2.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(1)));
        section2.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(1)));

        section2.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(2)));
        section2.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(2)));
        section2.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(2)));

        section2.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(3)));
        section2.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(3)));
        section2.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(3)));
        return section2;
    }

    private List<Coordinate> getSection3() {
        section3.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(1)));
        section3.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(1)));
        section3.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(1)));

        section3.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(2)));
        section3.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(2)));
        section3.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(2)));

        section3.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(3)));
        section3.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(3)));
        section3.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(3)));
        return section3;
    }

    private List<Coordinate> getSection4() {
        section4.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(4)));
        section4.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(4)));
        section4.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(4)));

        section4.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(5)));
        section4.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(5)));
        section4.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(5)));

        section4.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(6)));
        section4.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(6)));
        section4.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(6)));
        return section4;
    }

    private List<Coordinate> getSection5() {
        section5.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(4)));
        section5.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(4)));
        section5.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(4)));

        section5.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(5)));
        section5.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(5)));
        section5.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(5)));

        section5.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(6)));
        section5.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(6)));
        section5.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(6)));
        return section5;
    }

    private List<Coordinate> getSection6() {
        section6.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(4)));
        section6.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(4)));
        section6.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(4)));

        section6.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(5)));
        section6.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(5)));
        section6.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(5)));

        section6.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(6)));
        section6.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(6)));
        section6.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(6)));
        return section6;
    }

    private List<Coordinate> getSection7() {
        section7.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(7)));
        section7.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(7)));
        section7.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(7)));

        section7.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(8)));
        section7.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(8)));
        section7.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(8)));

        section7.add(new Coordinate(Tabulation.columnRawVal(1), Tabulation.rowRawVal(9)));
        section7.add(new Coordinate(Tabulation.columnRawVal(2), Tabulation.rowRawVal(9)));
        section7.add(new Coordinate(Tabulation.columnRawVal(3), Tabulation.rowRawVal(9)));
        return section7;
    }

    private List<Coordinate> getSection8() {
        section8.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(7)));
        section8.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(7)));
        section8.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(7)));

        section8.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(8)));
        section8.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(8)));
        section8.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(8)));

        section8.add(new Coordinate(Tabulation.columnRawVal(4), Tabulation.rowRawVal(9)));
        section8.add(new Coordinate(Tabulation.columnRawVal(5), Tabulation.rowRawVal(9)));
        section8.add(new Coordinate(Tabulation.columnRawVal(6), Tabulation.rowRawVal(9)));
        return section8;
    }

    private List<Coordinate> getSection9() {
        section9.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(7)));
        section9.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(7)));
        section9.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(7)));

        section9.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(8)));
        section9.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(8)));
        section9.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(8)));

        section9.add(new Coordinate(Tabulation.columnRawVal(7), Tabulation.rowRawVal(9)));
        section9.add(new Coordinate(Tabulation.columnRawVal(8), Tabulation.rowRawVal(9)));
        section9.add(new Coordinate(Tabulation.columnRawVal(9), Tabulation.rowRawVal(9)));

        return section9;
    }
}