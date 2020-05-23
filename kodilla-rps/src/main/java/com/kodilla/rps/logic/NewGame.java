package com.kodilla.rps.logic;

public class NewGame extends Thread {
    @Override
    public void run() {
        StartGame startGame = new StartGame();
        startGame.start();
    }
}
