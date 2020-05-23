package com.kodilla.rps.extension;

import com.kodilla.rps.logic.Player;

import java.util.Random;
import java.util.Scanner;

import static com.kodilla.rps.extension.Instructions.*;
import static com.kodilla.rps.extension.ProcessGame.*;

public class StartGame_SpockLizardExtension {
    public void start() {
        Scanner s = new Scanner(System.in);
        boolean end = false;
        boolean hardMode;
        boolean graphicsOn;
        boolean colorOn = false;

        Player newPlayer;
        int roundsToWin;
        int roundsWonPlayer = 0;
        int roundsWonCPU = 0;

        String choicePlayer;
        int choiceCPU;
        String choiceCPUText;
        String roundWinner;

        Random random = new Random();
        NewGame_SLExtension newGame = new NewGame_SLExtension();
        BannersASCII bannersASCII = new BannersASCII();

        printInstructions();
        System.out.println("Please enter your name: ");
        newPlayer = new Player(s.nextLine());
        roundsToWin = roundsToWin(s);
        hardMode = choosingHardMode(s);
        graphicsOn = graphicsOptions(s);
        if (graphicsOn) colorOn = graphicsColor(s);

        while (!end) {
            System.out.println("Choose your weapon (or type x - exit, n - new game, c - controls, h - what beats what):");
            choicePlayer = s.next();
            if (choiceName(choicePlayer).equals("x")) { break; }
            if (choiceName(choicePlayer).equals("n")) { newGame.start(); break; }
            if (choiceName(choicePlayer).equals("c")) { printControls(); continue;}
            if (choiceName(choicePlayer).equals("h")) { printWhatBeatsWhat(); continue;}

            choiceCPU = random.nextInt(5) + 1;
            choiceCPUText = Integer.toString(choiceCPU);
            if (hardMode) choiceCPUText = cpuSetResponse(choiceName(choicePlayer), (random.nextInt(4) + 1));

            System.out.println(newPlayer.getName() + ": " + choiceName(choicePlayer) + "   ---   CPU: " + choiceName(choiceCPUText));

            roundWinner = whoWinsTheRound(choiceName(choicePlayer), choiceName(choiceCPUText), newPlayer);
            if (roundWinner.equals("playerWins")) {
                roundsWonPlayer++;
            }
            if (roundWinner.equals("CPUWins")) {
                roundsWonCPU++;
            }

            graphics(graphicsOn, colorOn, roundWinner, choiceName(choicePlayer), choiceName(choiceCPUText));

            System.out.println("Current result: " + newPlayer.getName() + ": " + roundsWonPlayer + "\tCPU: " + roundsWonCPU);

            if (roundsWonPlayer == roundsToWin || roundsWonCPU == roundsToWin) {
                System.out.println("\nFinal result: \n" + newPlayer.getName() + ": " + roundsWonPlayer + "\tCPU: " + roundsWonCPU);
                if (roundsWonPlayer > roundsWonCPU) {
                    bannersASCII.playerWins();
                    System.out.println(newPlayer.getName() + ", you have won! Congratulations!");
                } else {
                    bannersASCII.cpuWins();
                    System.out.println("Maybe next time " + newPlayer.getName());
                }

                endGameOrNewGame(newGame);
                end = true;
            }
        }
    }
}
