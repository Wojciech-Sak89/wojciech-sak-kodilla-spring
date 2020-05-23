package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().addTask("Learn Design Patterns");
        board.getDoneList().addTask("Learn Java Syntax");
        board.getInProgressList().addTask("Learn Spring");
        //Then
        Assert.assertEquals("Learn Design Patterns", board.getToDoList().getTasks().get(0));
        Assert.assertEquals("Learn Java Syntax", board.getDoneList().getTasks().get(0));
        Assert.assertEquals("Learn Spring", board.getInProgressList().getTasks().get(0));
    }
}
