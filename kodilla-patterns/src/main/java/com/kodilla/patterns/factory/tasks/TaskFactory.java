package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Present", "coffee machine", 50);
            case PAINTING:
                return new PaintingTask("Renovation", "blue", "wall");
            case DRIVING:
                return new DrivingTask("Big Trip", "USA", "myCar");
            default:
                return null;
        }

    }
}
