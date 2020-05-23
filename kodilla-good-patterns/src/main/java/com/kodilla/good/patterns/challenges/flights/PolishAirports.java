package com.kodilla.good.patterns.challenges.flights;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PolishAirports {
    private final HashSet<DepartureCity> citiesWithAirports;

    public PolishAirports(HashSet<DepartureCity> citiesWithAirports) {
        this.citiesWithAirports = citiesWithAirports;
    }

    private HashSet<DepartureCity> citiesWithConnectionTo(String cityName) {
        HashSet<DepartureCity> citiesWithQueriedConnection = new HashSet<>();

        for (DepartureCity departureCity : citiesWithAirports) {
            if (departureCity.getDestinationsNames().contains(cityName)) {
                citiesWithQueriedConnection.add(departureCity);
            }
        }

        return citiesWithQueriedConnection;
    }

    public void printCitiesWithConnectionTo(String cityName) {
        Set<DepartureCity> cities = citiesWithConnectionTo(cityName);

        System.out.println("Cities with connection to " + cityName + ":");

        cities.stream()
                .map(DepartureCity::getCityName)
                .forEach(System.out::println);
    }

    public void printFlightsFrom(String cityName) {
        System.out.println("Available destinations from " + cityName + ":");

        citiesWithAirports.stream()
                .filter(departureCity -> departureCity.getCityName().equals(cityName))
                .map(DepartureCity::getDestinationsNames)
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }

    public void printConnectingCities(String departureCity, String destinationCity) {
        System.out.println("Connecting cities for travel FROM " + departureCity + " TO " + destinationCity);

        citiesWithAirports.stream()
                .filter(depCity -> depCity.getCityName().equals(departureCity))
                .flatMap(depCity -> depCity.getDestinationCities().stream())
                .filter(depCity -> citiesWithConnectionTo(destinationCity).contains(depCity))
                .map(DepartureCity::getCityName)
                .forEach(System.out::println);
    }

}