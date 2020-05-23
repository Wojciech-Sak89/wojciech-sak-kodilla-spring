package com.kodilla.good.patterns.challenges.allegro;

public class OrderDto {

    public OrderDto(User user, boolean orderSuccessfullyFinished) {
        if (orderSuccessfullyFinished) {
            System.out.println("*** " + user.getName() + ", your order has been processed correctly ***");
        } else {
            System.out.println("*** Order Error. Please try again ***");
        }

    }
}
