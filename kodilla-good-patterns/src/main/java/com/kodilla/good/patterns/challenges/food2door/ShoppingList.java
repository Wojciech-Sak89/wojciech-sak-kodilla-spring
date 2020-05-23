package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;

public class ShoppingList {
    public static HashMap<String, Integer> first() {
        HashMap<String, Integer> myList1 = new HashMap<>();
        myList1.put("jarmuż", 15);
        myList1.put("dynia", 10);
        myList1.put("siemię lniane", 50);

        return myList1;
    }

    public static HashMap<String, Integer> second() {
        HashMap<String, Integer> myList2 = new HashMap<>();
        myList2.put("orzechy", 150);
        myList2.put("miód", 10);
        myList2.put("rokitnik", 50);

        return myList2;
    }

    public static HashMap<String, Integer> third() {
        HashMap<String, Integer> myList3 = new HashMap<>();
        myList3.put("kasza", 15);
        myList3.put("rokitnik", 10);
        myList3.put("pietruszka", 5);

        return myList3;
    }
}
