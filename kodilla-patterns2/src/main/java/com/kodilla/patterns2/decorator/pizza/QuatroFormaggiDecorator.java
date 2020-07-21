package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class QuatroFormaggiDecorator extends AbstractPizzaOrderDecorator {
    public QuatroFormaggiDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Quatro Formaggi (mozzarella, grana padano, gorgonzola, ricotta, mint)";
    }
}
