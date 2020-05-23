package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AllegroOrderService implements OrderService {
    int orderCost = 0;
    int userAvailableMoney;

    @Override
    public boolean validateTransaction(User user, HashMap<String, Integer> items, LocalDate timeOfOrder) {
        userAvailableMoney = user.getMoney();

        System.out.println("Processing order queue... now processing order from " + timeOfOrder + "\n");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            orderCost += entry.getValue();
        }

        if (userAvailableMoney >= orderCost) {
            user.checkout(orderCost);
            return true;
        }

        return false;
    }

}
