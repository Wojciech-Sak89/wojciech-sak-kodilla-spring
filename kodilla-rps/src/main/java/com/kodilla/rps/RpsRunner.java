package com.kodilla.rps;


import com.kodilla.rps.extension.StartGame_SpockLizardExtension;

public class RpsRunner {
    public static void main(String[] args) {
//        StartGame startGame = new StartGame();
//        startGame.start();

        StartGame_SpockLizardExtension startGame_SpockLizardExtension = new StartGame_SpockLizardExtension();
        startGame_SpockLizardExtension.start();
    }

}