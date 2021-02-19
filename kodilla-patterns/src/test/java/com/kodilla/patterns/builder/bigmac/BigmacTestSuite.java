package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bigmac.BUN_SESAME)
                .ingredient(Bigmac.INGREDIENT_BACON)
                .burgers(2)
                .sauce(Bigmac.SAUCE_1000ISLAND)
                .ingredients(Bigmac.INGREDIENT_CHILI_PEPPER, Bigmac.INGREDIENT_CUCUMBER)
                .ingredient(Bigmac.INGREDIENT_MUSHROOMS)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(4, howManyIngredients);
    }
}