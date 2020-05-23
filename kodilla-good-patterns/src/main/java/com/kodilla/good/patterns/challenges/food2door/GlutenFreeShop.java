package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements Shop {
    private final HashMap<String, Integer> glutenFreeShop = new HashMap<>();

    @Override
    public ShopInfo shopInfo() {
        return new ShopInfo("GlutenFreeShop", "London", 111000222);
    }

    @Override
    public Repository availableProducts() {
        glutenFreeShop.put("orzechy", 100);
        glutenFreeShop.put("miód", 50);
        glutenFreeShop.put("żurawina", 35);

        return new Repository(glutenFreeShop);
    }

    @Override
    public void process(Order order) {
        if (order.getCompanyName().equals(shopInfo().getShopName())) {
            for (Map.Entry<String, Integer> entry : order.getProducts().entrySet()) {
                availableProducts().reserve(entry.getKey(), entry.getValue());
            }

            applyDiscount(order);

        } else {
            System.out.println("Sorry, you are in wrong shop");
        }
    }

    private void applyDiscount(Order order) {
        if (order.discountCode().equals("abc")) {
            System.out.println("Discount implemented!");
        } else {
            System.out.println("Wrong code!");
        }
    }
}
