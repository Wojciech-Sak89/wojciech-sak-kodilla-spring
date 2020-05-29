package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bigmac {
    private final String bun;
    private final String sauce;
    private final int burgers;
    private final List<String> ingredients;

    public static final String BUN_SESAME = "SEASAME";
    public static final String BUN_GRAHAM = "GRAHAM";

    public static final String SAUCE_1000ISLAND = "1000 ISLAND";
    public static final String SAUCE_STANDARD = "STANDARD";
    public static final String SAUCE_BARBECUE = "BARBECUE";

    public static final String INGREDIENT_LETTUCE = "LETTUCE";
    public static final String INGREDIENT_ONION = "ONION";
    public static final String INGREDIENT_BACON = "BACON";
    public static final String INGREDIENT_CUCUMBER = "CUCUMBER";
    public static final String INGREDIENT_CHILI_PEPPER = "CHILI PEPPER";
    public static final String INGREDIENT_MUSHROOMS = "MUSHROOMS";
    public static final String INGREDIENT_SHRIMP = "SHRIMP";

    public static class BigmacBuilder {
        private String bun, sauce;
        private int burgers;
        private final List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public BigmacBuilder ingredients(String... ingredients) {
            this.ingredients.addAll(Arrays.asList(ingredients));
            return this;
        }

        public Bigmac build() {
            if (burgers > 3) {
                throw new IllegalStateException("We sell BigMacs with maximum of 3 burgers");
            }
            return new Bigmac(bun, sauce, burgers, ingredients);
        }
    }

    private Bigmac(String bun, String sauce, int burgers, List<String> ingredients) {
        this.bun = bun;
        this.sauce = sauce;
        this.burgers = burgers;
        this.ingredients = ingredients;
    }

    public String getBun() {
        return bun;
    }

    public String getSauce() {
        return sauce;
    }

    public int getBurgers() {
        return burgers;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", sauce='" + sauce + '\'' +
                ", burgers=" + burgers +
                ", ingredients=" + ingredients +
                '}';
    }
}
