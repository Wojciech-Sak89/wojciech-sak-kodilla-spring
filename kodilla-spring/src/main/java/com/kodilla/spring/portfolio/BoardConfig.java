package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("toDo")
    TaskList toDoList;

    @Autowired
    @Qualifier("inProgress")
    TaskList inProgressList;

    @Autowired
    @Qualifier("done")
    TaskList doneList;

    @Bean
    public Board getBoard() {
        return new Board(toDoList, inProgressList, doneList);
    }

    @Bean(name = "toDo")
    @Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList(new ArrayList<>());
    }

    @Bean(name = "inProgress")
    @Scope("prototype")
    public TaskList getInProgressListList() {
        return new TaskList(new ArrayList<>());
    }

    @Bean(name = "done")
    @Scope("prototype")
    public TaskList getDoneList() {
        return new TaskList(new ArrayList<>());
    }
}


/*
@Configuration
public class ReaderConfig {
    @Autowired
    @Qualifier("book1")
    Book book;

    @Bean
    public Reader getReader() {
        return new Reader(book);
    }

    @Bean(name = "book1")
    @Scope("prototype")
    public Book getBookOne() {
        return new Book("The book number one");
    }

    @Bean(name = "book2")
    @Scope("prototype")
    @Conditional(IfDayIsOddCondition.class)
    public Book getBookTwo() {
        return new Book("The book number two");
    }
}
*/