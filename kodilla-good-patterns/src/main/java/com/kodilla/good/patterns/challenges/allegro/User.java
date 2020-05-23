package com.kodilla.good.patterns.challenges.allegro;

public class User {
    private String name;
    private String phoneNumber;
    private int money;

    public User(String name, String phoneNumber, int money) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMoney() {
        return money;
    }

    public void checkout(int money) {
        this.money -= money;
    }
}
