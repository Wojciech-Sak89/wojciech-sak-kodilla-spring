package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;
import java.util.HashMap;

public class OrderRequest {
    private User user;
    private HashMap<String, Integer> orderedItems;
    private LocalDate localDate;

    public OrderRequest(User user, HashMap<String, Integer> orderedItems, LocalDate localDate) {
        this.user = user;
        this.orderedItems = orderedItems;
        this.localDate = localDate;
    }

    public User getUser() {
        return user;
    }

    public HashMap<String, Integer> getOrderedItems() {
        return orderedItems;
    }

    public LocalDate getDateOfOrder() {
        return localDate;
    }
}
