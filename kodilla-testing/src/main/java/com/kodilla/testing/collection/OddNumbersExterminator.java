package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> evenNumbersList = new ArrayList<>();
        for (int number : numbers) {
            if (number %2 == 0) {
                evenNumbersList.add(number);
            }
        }
        return evenNumbersList;
    }
}
