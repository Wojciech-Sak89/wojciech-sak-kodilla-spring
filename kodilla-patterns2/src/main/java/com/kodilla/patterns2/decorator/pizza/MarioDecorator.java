package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MarioDecorator extends AbstractPizzaOrderDecorator {
    public MarioDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Mario (mozzarella, Italian bacon pancetta, Italian sausage, red onion, garlic)";
    }
}
