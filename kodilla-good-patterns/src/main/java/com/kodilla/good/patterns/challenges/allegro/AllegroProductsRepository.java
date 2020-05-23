package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;
import java.util.HashMap;

public class AllegroProductsRepository implements ProductsRepository {
    @Override
    public void createOrder(User user, HashMap<String, Integer> items, LocalDate timeOfOrder) {
        System.out.println("Reserving items from magazine for: " + user.getName());
        System.out.println("Items and their cost: " + items);
        System.out.println("Date of order: " + timeOfOrder + "\n");
    }
}
