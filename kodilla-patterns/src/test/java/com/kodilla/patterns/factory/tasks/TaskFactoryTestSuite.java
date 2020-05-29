package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testTaskFactory_Shopping() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING);
        shoppingTask.executeTask();
        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Present", shoppingTask.getTaskName());
    }

    @Test
    public void testTaskFactory_Painting() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.createTask(TaskFactory.PAINTING);
        shoppingTask.executeTask();
        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Renovation", shoppingTask.getTaskName());
    }

    @Test
    public void testTaskFactory_Driving() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.createTask(TaskFactory.DRIVING);
        shoppingTask.executeTask();
        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Big Trip", shoppingTask.getTaskName());
    }
}
