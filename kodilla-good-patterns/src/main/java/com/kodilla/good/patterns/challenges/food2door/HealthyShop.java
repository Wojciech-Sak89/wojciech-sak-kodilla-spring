package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HealthyShop implements Shop {
    private final HashMap<String, Integer> healthyShop = new HashMap<>();
    private final Random random = new Random();

    @Override
    public ShopInfo shopInfo() {
        return new ShopInfo("HealthyShop", "London", 111000222);
    }

    @Override
    public Repository availableProducts() {
        healthyShop.put("pietruszka", 100);
        healthyShop.put("kasza", 50);
        healthyShop.put("rokitnik", 35);

        return new Repository(healthyShop);
    }

    @Override
    public void process(Order order) {
        if (order.getCompanyName().equals(shopInfo().getShopName())) {
            for (Map.Entry<String, Integer> entry : order.getProducts().entrySet()) {
                availableProducts().reserve(entry.getKey(), entry.getValue());
            }

            generateCoupon(order, 3);

        } else {
            System.out.println("Sorry, you are in wrong shop");
        }
    }

    private void generateCoupon(Order order, int minimumOrderSizeForDiscount) {
        if (order.getProducts().size() >= minimumOrderSizeForDiscount) {
            System.out.println("You have bought at least " + minimumOrderSizeForDiscount +
                    " products, here is your discount for next shopping: " +
                    random.nextInt(1000 + 199));
        }
    }
}
