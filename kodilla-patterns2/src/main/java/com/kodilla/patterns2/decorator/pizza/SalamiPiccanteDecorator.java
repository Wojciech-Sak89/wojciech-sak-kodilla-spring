package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SalamiPiccanteDecorator extends AbstractPizzaOrderDecorator {
    public SalamiPiccanteDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Salami Piccante (mozzarella, salami piccante, red onion)";
    }
}
