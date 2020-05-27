package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library originalLibrary = new Library("Original Library");

        Book book1 = new Book("Snowcrash", "Neal Stephenson", LocalDate.of(1991, Month.JANUARY,1));
        Book book2 = new Book("Lord of The Rings", "J. R. R. Tolkien", LocalDate.of(1968, Month.JANUARY,1));
        Book book3 = new Book("The Terror", "Dan Simmons", LocalDate.of(2007, Month.JANUARY,1));

        originalLibrary.getBooks().add(book1);
        originalLibrary.getBooks().add(book2);
        originalLibrary.getBooks().add(book3);

        //making a shallow clone of object originalLibrary
        Library clonedLibrary = null;
        try {
            clonedLibrary = originalLibrary.shallowCopy();
            clonedLibrary.setName("Cloned Library - shallow");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object originalLibrary
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = originalLibrary.deepCopy();
            deepClonedLibrary.setName("Cloned Library - deep");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        originalLibrary.getBooks().remove(book3);

        //Then
        System.out.println(originalLibrary);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(2, originalLibrary.getBooks().size());
        Assert.assertEquals(2, clonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), originalLibrary.getBooks());
    }
}