package com.kodilla.rps.extension;

public class NewGame_SLExtension extends Thread {
    @Override
    public void run() {
        StartGame_SpockLizardExtension startGame_SpockLizardExtension = new StartGame_SpockLizardExtension();
        startGame_SpockLizardExtension.start();
    }
}
