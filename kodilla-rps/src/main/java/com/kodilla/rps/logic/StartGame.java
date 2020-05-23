package com.kodilla.rps.logic;

import java.util.Random;
import java.util.Scanner;

public class StartGame {
    public void start() {
        Scanner s = new Scanner(System.in);
        boolean end = false;

        Player newPlayer;
        int roundsToWin = 0;
        int roundsWonPlayer = 0;
        int roundsWonCPU = 0;

        String choicePlayer;
        int choiceCPU;
        String choiceCPUText;
        String roundWinner;

        Random random = new Random();
        NewGame newGame = new NewGame();

        printInstructions();
        System.out.println("Please enter your name: ");
        newPlayer = new Player(s.nextLine());
        roundsToWin = roundsToWin(s);

        while (!end) {
            System.out.println("Make a choice (1, 2, 3, x, n):");
            choicePlayer = s.next();
            if (choicePlayer.equals("x")) { break; }
            if (choicePlayer.equals("n")) { newGame.start(); break; }

            choiceCPU = random.nextInt(3) + 1;
            choiceCPUText = Integer.toString(choiceCPU);
            System.out.println(newPlayer.getName() + ": " + choiceName(choicePlayer) + "   ---   CPU: " + choiceName(choiceCPUText));

            roundWinner = whoWinsTheRound(choicePlayer, choiceCPUText, newPlayer);
            if (roundWinner.equals("playerWins")) { roundsWonPlayer++; }
            if (roundWinner.equals("CPUWins")) { roundsWonCPU++; }

            System.out.println("Current result: " + newPlayer.getName() + ": " + roundsWonPlayer + "\tCPU: " + roundsWonCPU);

            if (roundsWonPlayer == roundsToWin || roundsWonCPU == roundsToWin) {
                System.out.println("Final result: " + newPlayer.getName() + ": " + roundsWonPlayer + "\tCPU: " + roundsWonCPU);
                if (roundsWonPlayer > roundsWonCPU) {
                    System.out.println(newPlayer.getName() + " wins! Congratulations!");
                } else {
                    System.out.println("CPU wins! Maybe next time " + newPlayer.getName());
                }

                endGameOrNewGame(newGame);
                end = true;
            }
        }
    }

    public void establishGame() {

    }

    public void printInstructions() {
        System.out.println("ROCK PAPER SCISSORS SPOCK LIZARD - THE GAME\n" +
                "Hello! Here you have an opportunity to play a modified version of classic game known as ROCK PAPER SCISSORS!\n" +
                "\n it add to the game" +
                "\nHOW TO PLAY?\n" +
                "After choosing number of rounds needed to win the game press:\n" +
                "1 - to play ROCK\n" +
                "2 - to play PAPER\n" +
                "3 - to play SCISSORS\n" +
                "x - to end the game\n" +
                "n - to start a new game\n" +
                "Reminder: ROCK beats SCISSORS \t SCISSORS beats PAPER \t PAPER beats ROCK" + // 1 beats 3, 3 beats 2, 2 beats 1 ELSE draw
                "\nAfter you press 1-3 CPU will respond. Don't worry, \nit doesn't know what you have chosen, like in real game! :-)\n");
    }

    public int roundsToWin(Scanner scanner) {
        int roundsToWin = 0;
        boolean hasNextInt = false;
        while (!hasNextInt) {
            System.out.println("Enter number of rounds needed to win the game:");
            hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                roundsToWin = scanner.nextInt();
                return roundsToWin;
            } else {
                System.out.println("Invalid number of rounds! Please be sure to enter an integer.");
                scanner.nextLine();
            }
        }
        return -1;
    }

    public String choiceName(String choice) {
        switch (choice) {
            case "1":
                return "ROCK";
            case "2":
                return "PAPER";
            case "3":
                return "SCISSORS";
            case "n":
                return "n";
            case "x":
                return "x";

        }
        return "Invalid choice! Please enter one of these: 1, 2, 3, x, n";
    }

    public String whoWinsTheRound(String inputPlayer, String inputCPU, Player player) {
        //PLAYER WINS
        if ((inputPlayer.equals("1") && inputCPU.equals("3")) || (inputPlayer.equals("3") && inputCPU.equals("2")) || (inputPlayer.equals("2") && inputCPU.equals("1"))) {
            System.out.println(player.getName() + " wins this round!");
            return "playerWins";
        }
        // CPU WINS
        if ((inputPlayer.equals("3") && inputCPU.equals("1")) || (inputPlayer.equals("2") && inputCPU.equals("3")) || (inputPlayer.equals("1") && inputCPU.equals("2"))) {
            System.out.println("CPU wins this round!");
            return "CPUWins";
        }
        // DRAW
        if (inputPlayer.equals(inputCPU)) {
            System.out.println("You have chosen same as CPU! (or CPU same as you...)");
            System.out.println("Current round: DRAW");
            return "draw";
        }
        return "Error";
    }

    public void endGameOrNewGame(NewGame newGame) {
        String finalChoice;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Press n to start new game. Press x to quit.");
            finalChoice = s.nextLine();
            if (finalChoice.equals("x")) {
                break;
            } else if (finalChoice.equals("n")) {
                newGame.start();
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
