package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Dan Simmons", "Terror", 2015, "AOL15"));
        bookSet.add(new Book("Dan Simmons", "Abominacja", 2020, "AOL16"));
        bookSet.add(new Book("Daniel Keyes", "Kwiaty dla Algernona", 1966, "AOL17"));
        bookSet.add(new Book("Arthur C. Clarke", "Koniec dzieciństwa", 1954, "AOL18"));
        bookSet.add(new Book("Roger Zelazny", "Aleja potępienia", 1968, "AOL19"));
        bookSet.add(new Book("Harry Harrison", "Przestrzeni! Przestrzeni!", 1966, "AOL20"));
        bookSet.add(new Book("Brian Aldiss", "Non stop", 1958, "AOL21"));
        bookSet.add(new Book("Robert A. Heinlein", "Hiob. Komedia sprawiedliwości", 1984, "AOL22"));
        bookSet.add(new Book("Brian Aldiss", "Cieplarnia", 1960, "AOL23"));
        bookSet.add(new Book("Robert A. Heinlein", "Drzwi do lata", 1957, "AOL24"));
        MedianAdapter adapter = new MedianAdapter();

        //When
        int median = adapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(median);
        assertEquals(1966, median);
    }
}
