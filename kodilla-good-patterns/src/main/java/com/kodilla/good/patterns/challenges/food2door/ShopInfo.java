package com.kodilla.good.patterns.challenges.food2door;

public class ShopInfo {
    private final String shopName;
    private final String address;
    private final int phoneNum;

    public ShopInfo(String shopName, String address, int phoneNum) {
        this.shopName = shopName;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getShopName() {
        return shopName;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNum() {
        return phoneNum;
    }
}
