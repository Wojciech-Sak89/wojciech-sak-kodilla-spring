package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTestSuite {
    int counter = 0;

    @Before
    public void before() {
        System.out.println("Test Case " + "#" + counter + " begins");
    }

    @After
    public void after() {
        System.out.println("Test Case " + "#" + counter + " has ended\n");
        counter++;
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        ArrayList<Integer> emptyArrayList = new ArrayList<>();
        ArrayList<Integer> testEmptyArrayList;

        // When
        OddNumbersExterminator removeOdd = new OddNumbersExterminator();
        testEmptyArrayList = removeOdd.exterminate(emptyArrayList);
        System.out.println("Testing " + testEmptyArrayList.toString());

        // Then
        Assert.assertEquals(0, testEmptyArrayList.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        // Given
        ArrayList<Integer> evenAndOddNumbersList = new ArrayList<>();
        evenAndOddNumbersList.add(1);
        evenAndOddNumbersList.add(2);
        evenAndOddNumbersList.add(3);
        evenAndOddNumbersList.add(4);
        evenAndOddNumbersList.add(5);

        ArrayList<Integer> testIsItEvenList;

        ArrayList<Integer> evenList = new ArrayList<>();
        evenList.add(2);
        evenList.add(4);

        // When
        OddNumbersExterminator removeOdd = new OddNumbersExterminator();
        testIsItEvenList = removeOdd.exterminate(evenAndOddNumbersList);
        System.out.println("Testing " + testIsItEvenList.toString());

        // Then
        Assert.assertEquals(evenList, testIsItEvenList);

    }
}
