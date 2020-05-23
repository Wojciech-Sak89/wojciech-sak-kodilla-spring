package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;
import java.util.HashMap;

public class OrderRequestRetriever {
    User user1 = new User("Lenny", "222111333", 2000);
    HashMap<String,Integer> user1OrderedItemsWithCosts = new HashMap<>();
    LocalDate user1DateOfOrder = LocalDate.of(2020, 5, 14);

    public OrderRequest retrieve() {
        user1OrderedItemsWithCosts.put("Drako", 99);
        user1OrderedItemsWithCosts.put("GTA V", 120);
        user1OrderedItemsWithCosts.put("kapcie", 115);
        user1OrderedItemsWithCosts.put("szczoteczka do zebów", 75);

        return new OrderRequest(user1, user1OrderedItemsWithCosts, user1DateOfOrder);
    }
}
