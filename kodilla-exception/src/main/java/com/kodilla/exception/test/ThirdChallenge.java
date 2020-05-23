package com.kodilla.exception.test;

public class ThirdChallenge {
    public static void main(String[] args) {
        Flight toAmber = new Flight("Warsaw", "Amber");
        Flight toParis = new Flight("Amsterdam", "Paris");
        Flight toWuhan = new Flight("Tokio", "Wuhan");

        FlightSearch flightSearch = new FlightSearch();

        try {
            System.out.println("\nTrying get to Paris");
            System.out.println("Can I book flight to Paris? --" + (flightSearch.findFlight(toParis) ? " Yes, of course" : " No, that's not possible right now"));

            System.out.println("\nTrying get to Wuhan");
            System.out.println("Can I book flight to Wuhan? --" + (flightSearch.findFlight(toWuhan) ? " Yes, of course" : " No, that's not possible right now"));

            System.out.println("\nTrying get to Amber");
            System.out.println("Can I book flight to Amber? --" + (flightSearch.findFlight(toAmber) ? " Yes, of course" : " No, that's not possible right now"));

        } catch (RouteNotFoundException e) {
            System.out.println("Looks like you can't get there, at least not from this airport: " + e);
        } finally {
            System.out.println("Wherever you are, don't forget to call me!");
        }

    }
}
