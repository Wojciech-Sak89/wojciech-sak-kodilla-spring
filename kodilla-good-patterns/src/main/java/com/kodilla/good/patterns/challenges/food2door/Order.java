package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;

public class Order {
    private final String companyName;
    private final HashMap<String, Integer> products;

    public Order(String companyName, HashMap<String, Integer> products) {
        this.companyName = companyName;
        this.products = products;
    }

    public String getCompanyName() {
        return companyName;
    }

    public HashMap<String, Integer> getProducts() {
        return products;
    }

    public String discountCode() {
        return "abc";
    }
}
