package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    String taskName,where, using;
    boolean taskExecuted;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        if (where.equals("home") || using.equals("myCar")) {
            taskExecuted = true;
        }
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }
}
