package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Paris", false);
        airports.put("Wuhan", true);
        airports.put("London", false);
        airports.put("Seul", true);

        if (!airports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("There is no such destination!");
        }

        return airports.get(flight.getArrivalAirport());

    }

}
