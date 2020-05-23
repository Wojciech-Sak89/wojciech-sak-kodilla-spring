package com.kodilla.testing.shape;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle1 = new Circle(15.5);

        //When
        shapeCollector.addFigure(circle1);

        //Then
        assertEquals(1, shapeCollector.getShapes().size());
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle1 = new Triangle(5,5,5);

        //When
        boolean result = shapeCollector.removeFigure(triangle1);

        //Then
        assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle1 = new Triangle(5,5,5);
        Triangle triangle2 = new Triangle(4,5,5);
        shapeCollector.addFigure(triangle1);
        shapeCollector.addFigure(triangle2);

        //When
        boolean result = shapeCollector.removeFigure(triangle1);

        //Then
        assertTrue(result);
        assertEquals(1, shapeCollector.getShapes().size());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle1 = new Triangle(4,5,5);
        shapeCollector.addFigure(triangle1);

        //When
        Shape someShape = shapeCollector.getFigure(0);
        Triangle triangleTest = new Triangle(4,5,5);

        //Then
        assertEquals(someShape, triangleTest);
    }



//    @Test
//    public void testShowFigures() {
//        //Given
//        ShapeCollector shapeCollector = new ShapeCollector();
//
//        Triangle triangle = new Triangle(4,5,5);
//        Circle circle = new Circle(4.2);
//        Square square = new Square(222);
//
//        shapeCollector.addFigure(triangle);
//        shapeCollector.addFigure(circle);
//        shapeCollector.addFigure(square);
//
//        //When
//        ArrayList<String> figuresNames = new ArrayList<>();
//        figuresNames.add(0, "triangle");
//        figuresNames.add(1, "circle");
//        figuresNames.add(2, "square");
//
////        shapeCollector.showFigures();
//
//        //Then
//        assertEquals(figuresNames.get(0), triangle.getShapeName());
//        assertEquals(figuresNames.get(1), circle.getShapeName());
//        assertEquals(figuresNames.get(2), square.getShapeName());
//
//        assertEquals(3, shapeCollector.getShapes().size());
//    }

}
