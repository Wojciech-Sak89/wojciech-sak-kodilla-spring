package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Shop {
    private final HashMap<String, Integer> extraFoodRepository = new HashMap<>();

    @Override
    public ShopInfo shopInfo() {
        return new ShopInfo("ExtraFoodShop", "London", 111000222);
    }

    @Override
    public Repository availableProducts() {
        extraFoodRepository.put("dynia", 100);
        extraFoodRepository.put("jarmuż", 50);
        extraFoodRepository.put("siemię lniane", 35);

        return new Repository(extraFoodRepository);
    }

    @Override
    public void process(Order order) {
        if (order.getCompanyName().equals(shopInfo().getShopName())) {
            for (Map.Entry<String, Integer> entry : order.getProducts().entrySet()) {
                availableProducts().reserve(entry.getKey(), entry.getValue());
            }

        } else {
            System.out.println("Sorry, you are in wrong shop");
        }

    }
}
