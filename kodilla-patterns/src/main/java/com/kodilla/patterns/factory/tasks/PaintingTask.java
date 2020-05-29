package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    String taskName, color, whatToPaint;
    boolean taskExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        if (!color.equals("white") && whatToPaint.equals("wall")) {
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
