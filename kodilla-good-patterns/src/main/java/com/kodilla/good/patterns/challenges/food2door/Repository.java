package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;

public class Repository {
    HashMap<String, Integer> products;

    public Repository(HashMap<String, Integer> products) {
        this.products = products;
    }

    public void reserve(String productName, int amount) {
        if (products.containsKey(productName)) {
            System.out.println("Trying to reserve " + productName + "...");

            reduceInMagazine(productName, amount);

        } else {
            System.out.println("Reservation failed! There is no " + productName + " in database.");
        }
    }

    private void reduceInMagazine(String productName, int amount) {
        if (products.get(productName) >= amount) {
            products.put(productName, products.get(productName) - amount);

            System.out.println("Reservation of " + productName + " x " + amount + " was successful!");

        } else {
            System.out.println("Reservation was unsuccessful, there is not enough amount of " +
                    productName + " in repository");
        }
    }
}
