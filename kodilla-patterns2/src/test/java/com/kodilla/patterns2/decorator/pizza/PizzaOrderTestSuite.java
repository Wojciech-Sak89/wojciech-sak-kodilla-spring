package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(18), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Order Pizza", description);
    }

    @Test
    public void testSalamiPiccanteGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new SalamiPiccanteDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(23), calculatedCost);
    }

    @Test
    public void testSalamiPiccanteGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new SalamiPiccanteDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Order Pizza Salami Piccante (mozzarella, salami piccante, red onion)", description);
    }

    @Test
    public void testMarioGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MarioDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(25), calculatedCost);
    }

    @Test
    public void testMarioGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MarioDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Order Pizza Mario " +
                "(mozzarella, Italian bacon pancetta, Italian sausage, red onion, garlic)", description);
    }

    @Test
    public void testQuatroFormaggiGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new QuatroFormaggiDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(25), calculatedCost);
    }

    @Test
    public void testQuatroFormaggiGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new QuatroFormaggiDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Order Pizza Quatro Formaggi (mozzarella, grana padano, gorgonzola, ricotta, mint)",
                description);
    }

    @Test
    public void testBaseWithPineappleAnchoisGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PineappleDecorator(theOrder);
        theOrder = new AnchoisDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(27), calculatedCost);
    }

    @Test
    public void testBaseWithPineappleAnchoisGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PineappleDecorator(theOrder);
        theOrder = new AnchoisDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Order Pizza extra pineapple extra anchois", description);
    }

    @Test
    public void testExtraCheeseSauceGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new QuatroFormaggiDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new SauceDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(30), calculatedCost);
    }

    @Test
    public void testExtraCheeseSauceGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new QuatroFormaggiDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new SauceDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Order Pizza Quatro Formaggi (mozzarella, grana padano, gorgonzola, ricotta, mint)" +
                " extra cheese additional sauce", description);
    }
}
