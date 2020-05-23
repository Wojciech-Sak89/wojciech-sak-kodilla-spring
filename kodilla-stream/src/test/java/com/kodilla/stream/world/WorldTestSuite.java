package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

//    napisz test testGetPeopleQuantity(), który przetestuje czy metoda getPeopleQuantity() klasy World działa prawidłowo

    @Test
    public void testGetPeopleQuantity() {
        //Given
            // Countries
        Country poland = new Country("Poland", "38000000");
        Country germany = new Country("Germany", "80000000");
        Country italy = new Country("Italy", "60000000");

        Country china = new Country("China", "1563000000");
        Country russia = new Country("Russia", "538000000");
        Country india = new Country("India", "1238000000");

        Country egypt = new Country("Egypt", "128000000");
        Country rpa = new Country("RPA", "999000000");
        Country kenya = new Country("Kenya", "666000000");

            // Continents
        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(italy);

        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(russia);
        asia.addCountry(india);

        Continent africa = new Continent("Africa");
        africa.addCountry(egypt);
        africa.addCountry(rpa);
        africa.addCountry(kenya);

            // World
        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);


        //When
        BigDecimal worldPopulation = world.getPeopleQuantity();

        //Then
        BigDecimal expectedWorldPopulation = new BigDecimal("5310000000");
        Assert.assertEquals(expectedWorldPopulation, worldPopulation);
    }
}
