package com.kodilla.testing.shape;

import com.kodilla.testing.forum.ForumPost;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public ShapeCollector() {

    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        Shape shape = null;
        if (n >= 0 && n < shapes.size()) {
            shape = shapes.get(n);
        }
        return shape;
    }

    public void showFigures() {
        int counter = 1;
        for (Shape shape : shapes) {
            System.out.println("Figure #" + counter + " name: " + shape.getShapeName());
            counter++;
        }
    }
}
