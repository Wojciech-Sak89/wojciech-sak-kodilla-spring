package com.kodilla.good.patterns.challenges.flights;

import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class DepartureCity {
    HashSet<DepartureCity> destinationCities = new HashSet<>();
    City city;

    public DepartureCity(City city) {
        this.city = city;
    }

    public void addDestCity(DepartureCity departureCity) {
        destinationCities.add(departureCity);
    }

    public HashSet<String> getDestinationsNames() {
        return destinationCities.stream()
                .map(DepartureCity::getCityName)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public HashSet<DepartureCity> getDestinationCities() {
        return destinationCities;
    }

    public String getCityName() {
        return city.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartureCity that = (DepartureCity) o;
        return Objects.equals(destinationCities, that.destinationCities) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}