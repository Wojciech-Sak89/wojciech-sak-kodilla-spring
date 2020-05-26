package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void initializeLoggerClass() {
        Logger.getInstance().log("Some log info");
    }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String lastLog = Logger.getInstance().getLastLog();
        System.out.println("Last log: " + lastLog);
        //Then
        Assert.assertEquals("Some log info", lastLog);
    }
}
