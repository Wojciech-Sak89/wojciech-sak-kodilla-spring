package com.kodilla.good.patterns.challenges.flights;

import java.util.HashSet;

public class AirportsRetriever {
    private final City gdansk = new City("Gdańsk");
    private final City warszawa = new City("Warszawa");
    private final City poznan = new City("Poznań");
    private final City wroclaw = new City("Wrocław");
    private final City krakow = new City("Kraków");
    private final City lodz = new City("łódź");

    private final DepartureCity departureGda = new DepartureCity(gdansk);
    private final DepartureCity departureWar = new DepartureCity(warszawa);
    private final DepartureCity departurePoz = new DepartureCity(poznan);
    private final DepartureCity departureWro = new DepartureCity(wroclaw);
    private final DepartureCity departureKra = new DepartureCity(krakow);
    private final DepartureCity departureLod = new DepartureCity(lodz);

    public HashSet<DepartureCity> retrieve() {
        HashSet<DepartureCity> citiesWithAirports = new HashSet<>();
        departureGda.addDestCity(departureWar);
        departureGda.addDestCity(departurePoz);
        departureGda.addDestCity(departureWro);

        departureWar.addDestCity(departurePoz);
        departureWar.addDestCity(departureWro);
        departureWar.addDestCity(departureKra);

        departurePoz.addDestCity(departureWro);
        departurePoz.addDestCity(departureKra);
        departurePoz.addDestCity(departureLod);

        departureWro.addDestCity(departureKra);
        departureWro.addDestCity(departureLod);
        departureWro.addDestCity(departureGda);

        departureKra.addDestCity(departureLod);
        departureKra.addDestCity(departureGda);
        departureKra.addDestCity(departureWar);

        departureLod.addDestCity(departureGda);
        departureLod.addDestCity(departureWar);
        departureLod.addDestCity(departurePoz);

        citiesWithAirports.add(departureGda);
        citiesWithAirports.add(departureWar);
        citiesWithAirports.add(departurePoz);
        citiesWithAirports.add(departureWro);
        citiesWithAirports.add(departureKra);
        citiesWithAirports.add(departureLod);

        return citiesWithAirports;
    }
}
