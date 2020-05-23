package com.kodilla.good.patterns.challenges.food2door;

public interface Shop {
    ShopInfo shopInfo();
    Repository availableProducts();
    void process(Order order);

}
