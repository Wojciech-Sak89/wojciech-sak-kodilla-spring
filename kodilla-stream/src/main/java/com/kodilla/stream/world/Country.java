package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final String name;
    private final BigDecimal population;

    public Country(final String name, final String populationQuantity) {
        this.name = name;
        this.population = new BigDecimal(populationQuantity);
    }

    public BigDecimal getPeopleQuantity() {
        return population;
    }

}
