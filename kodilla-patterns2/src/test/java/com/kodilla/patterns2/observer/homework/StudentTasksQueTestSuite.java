package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class StudentTasksQueTestSuite {
    @Test
    public void testUpdate() {
        //Given
        KodillaMentor severusSnape = new KodillaMentor("Severus Snape");
        KodillaMentor minerwaMcGonagall = new KodillaMentor("Minerwa McGonagall");
        StudentTasksQue ronsTasks = new StudentTasksQue("Ron Weasley");
        StudentTasksQue harrysTasks = new StudentTasksQue("Harry Potter");
        StudentTasksQue hermionesTasks = new StudentTasksQue("Hermiona Granger");
        StudentTasksQue vincentsTasks = new StudentTasksQue("Vincent Crabbe");
        StudentTasksQue dracosTasks = new StudentTasksQue("Draco Malfoy");
        ronsTasks.registerObserver(minerwaMcGonagall);
        harrysTasks.registerObserver(minerwaMcGonagall);
        hermionesTasks.registerObserver(minerwaMcGonagall);
        vincentsTasks.registerObserver(severusSnape);
        dracosTasks.registerObserver(severusSnape);
        //When
        ronsTasks.addTask("Magic spell lvl 1 - compiler fix");
        ronsTasks.addTask("Historical essay 1 - CPU vs magic");
        harrysTasks.addTask("Magic spell lvl 1 - compiler fix");
        harrysTasks.addTask("Historical essay 1 - CPU vs magic");
        hermionesTasks.addTask("Magic spell lvl 3 - refactoring");
        hermionesTasks.addTask("Magic spell lvl 3 - debug");
        hermionesTasks.addTask("Historical essay 3 - Programming underwater");
        vincentsTasks.addTask("Elixir 1.1 - Focus enhancer");
        dracosTasks.addTask("Rouge 0.3 - How to use Stackoverflow?");
        //Then
        assertEquals(2, severusSnape.getUpdateCount());
        assertEquals(7, minerwaMcGonagall.getUpdateCount());
    }
}
