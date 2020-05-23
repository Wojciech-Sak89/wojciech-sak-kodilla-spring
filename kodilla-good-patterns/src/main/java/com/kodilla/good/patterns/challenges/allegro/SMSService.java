package com.kodilla.good.patterns.challenges.allegro;

public class SMSService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Sending message on " + user.getPhoneNumber());
        System.out.println("\"" + user.getName() + ", we have received your order request. In next email we will summarize your transaction\" \n");
    }
}
