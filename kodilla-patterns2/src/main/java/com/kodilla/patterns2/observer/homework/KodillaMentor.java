package com.kodilla.patterns2.observer.homework;

public class KodillaMentor implements Observer {
    private final String name;
    private int updateCount;

    public KodillaMentor(String name) {
        this.name = name;
    }

    @Override
    public void update(StudentTasksQue studentTasksQue) {
        System.out.println(name + ": You have new task to be checked from " + studentTasksQue.getStudentName() + "\n" +
                " (total number of students tasks: " + studentTasksQue.getTasks().size());
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
