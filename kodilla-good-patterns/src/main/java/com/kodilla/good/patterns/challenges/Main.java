package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.flights.AirportsRetriever;
import com.kodilla.good.patterns.challenges.flights.PolishAirports;

public class Main {

    public static void main(String[] args) {
//        MovieStore movieStore = new MovieStore();
//
//        String moviesTranslations = movieStore.getMovies().entrySet().stream()
//                .flatMap(stringListEntry -> stringListEntry.getValue().stream())
//                .collect(Collectors.joining("!"));
//
//        System.out.println(moviesTranslations);



//        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
//        OrderRequest orderRequest = orderRequestRetriever.retrieve();
//
//        ProductOrderService productOrderService = new ProductOrderService(
//                                            new SMSService(),
//                                            new AllegroOrderService(),
//                                            new AllegroProductsRepository());
//
//        productOrderService.process(orderRequest);


//        Order order1 = new Order("ExtraFoodShop", ShoppingList.first());
//        Order order2 = new Order("GlutenFREEDOOM", ShoppingList.second());
//        Order order3 = new Order("GlutenFreeShop", ShoppingList.second());
//        Order order4 = new Order("HealthyShop", ShoppingList.third());
//
//        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
//        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
//        HealthyShop healthyShop = new HealthyShop();
//
//        System.out.println("*** ExtraFoodShop Order ***");
//        extraFoodShop.process(order1);
//
//        System.out.println("\n*** GlutenFreeShop Order ...with typo ***");
//        glutenFreeShop.process(order2);
//
//        System.out.println("\n*** GlutenFreeShop Order ***");
//        glutenFreeShop.process(order3);
//
//        System.out.println("\n*** HealthyShop Order ***");
//        healthyShop.process(order4);

        AirportsRetriever airportsRetriever = new AirportsRetriever();
        PolishAirports polishAirports = new PolishAirports(airportsRetriever.retrieve());

        polishAirports.printFlightsFrom("Gdańsk");

        System.out.println("\n***************\n");
        polishAirports.printCitiesWithConnectionTo("Gdańsk");

        System.out.println("\n***************\n");
        polishAirports.printConnectingCities("Warszawa", "łódź");

    }

}
