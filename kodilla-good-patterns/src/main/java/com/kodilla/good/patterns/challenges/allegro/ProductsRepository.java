package com.kodilla.good.patterns.challenges.allegro;

import java.time.LocalDate;
import java.util.HashMap;

public interface ProductsRepository {
    void createOrder(User user, HashMap<String, Integer> items, LocalDate timeOfOrder);

}
