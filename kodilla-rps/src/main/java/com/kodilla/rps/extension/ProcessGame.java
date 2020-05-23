package com.kodilla.rps.extension;

import com.kodilla.rps.logic.Player;

import java.util.Scanner;

public class ProcessGame {

    public static int roundsToWin(Scanner scanner) {
        int roundsToWin;
        boolean hasNextInt = false;
        while (!hasNextInt) {
            System.out.println("Enter number of rounds needed to win the game:");
            hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                roundsToWin = scanner.nextInt();
                if(roundsToWin > 0) {
                    return roundsToWin;
                } else {
                    System.out.println("Invalid number of rounds! It has to be greater than zero!");
                    scanner.nextLine();
                    hasNextInt = false;
                }
            } else {
                System.out.println("Invalid number of rounds! Please be sure to enter an integer.");
                scanner.nextLine();
            }
        }
        return -1;
    }

    public static boolean choosingHardMode(Scanner scanner) {
        String flag;

        do {
            System.out.println("Would you like to play in hard mode? If yes, enter \"Y\", else enter \"N\"");
            System.out.println("In hard mode Player has only 25% chance to win a round, 25% chance for draw. CPU wins 50% of rounds.");
            flag = scanner.next().toUpperCase();

        } while (!flag.equals("Y") && !flag.equals("N"));
        if (flag.equals("Y")) { System.out.println("Hard Mode On"); return true; }
        if (flag.equals("N")) { System.out.println("Hard Mode Off"); return false; }

        return false;
    }

    public static boolean graphicsOptions(Scanner scanner) {
        String flag;

        do {
            System.out.println("Would you like to turn on graphics? If yes, enter \"Y\", else enter \"N\"");
            flag = scanner.next().toUpperCase();
        } while (!flag.equals("Y") && !flag.equals("N"));
        if (flag.equals("Y")) { System.out.println("Graphics On"); return true; }
        if (flag.equals("N")) { System.out.println("Graphics Off"); return false; }

        return false;
    }

    public static boolean graphicsColor(Scanner scanner) {
        String flag;

        do {
            System.out.println("In color or monochromatic? Enter \"C\" for color, \"M\" for monochromatic.");
            flag = scanner.next().toUpperCase();
        } while (!flag.equals("C") && !flag.equals("M"));
        if (flag.equals("C")) { System.out.println("Color On"); return true; }
        if (flag.equals("M")) { System.out.println("Color Off"); return false; }

        return false;
    }

    public static String choiceName(String choice) {
        switch (choice.toUpperCase()) {
            case "1":
            case "ROCK":
                return "ROCK";
            case "2":
            case "PAPER":
                return "PAPER";
            case "3":
            case "SCISSORS":
                return "SCISSORS";
            case "4":
            case "SPOCK":
                return "SPOCK";
            case "5":
            case "LIZARD":
                return "LIZARD";
            case "X":
                return "x";
            case "N":
                return "n";
            case "C":
                return "c";
            case "H":
                return "h";
        }
        return "Invalid choice!";
    }

    public static String whoWinsTheRound(String inputPlayer, String inputCPU, Player player) {
        // DRAW
        if (inputPlayer.equals(inputCPU)) {
            System.out.println("You have chosen same as CPU! (or CPU same as you...)");
            System.out.println("Current round: DRAW");
            return "draw";
        }

        //PLAYER WINS or CPU WINS
        if ((inputPlayer.equals("ROCK") && ((inputCPU.equals("SCISSORS")) || (inputCPU.equals("LIZARD"))))
                || (inputPlayer.equals("SCISSORS") && ((inputCPU.equals("PAPER")) || (inputCPU.equals("LIZARD"))))
                || (inputPlayer.equals("PAPER") && ((inputCPU.equals("ROCK")) || (inputCPU.equals("SPOCK"))))
                || (inputPlayer.equals("SPOCK") && ((inputCPU.equals("SCISSORS")) || (inputCPU.equals("ROCK"))))
                || (inputPlayer.equals("LIZARD") && ((inputCPU.equals("PAPER")) || (inputCPU.equals("SPOCK"))))) {
            System.out.println(player.getName() + " wins this round!");
            return "playerWins";
        } else {
            return "CPUWins";
        }
    }

    public static String cpuSetResponse(String inputPlayer, int option) {
        //player wins
        if (option == 1) {
            System.out.println("Player will WIN this round");
            if (inputPlayer.equals("SCISSORS") || inputPlayer.equals("ROCK")) { return "LIZARD"; }
            if (inputPlayer.equals("SPOCK") || inputPlayer.equals("PAPER")) { return "ROCK"; }
            if (inputPlayer.equals("LIZARD")) { return "SPOCK"; }
        }

        //draw
        if (option == 2) {
            System.out.println("There will be DRAW in this round");
            return inputPlayer;
        }

        //CPU wins
        if (option == 3 || option == 4) {
            System.out.println("Player will LOSE this round");
            if (inputPlayer.equals("SCISSORS") || inputPlayer.equals("ROCK")) { return "SPOCK"; }
            if (inputPlayer.equals("SPOCK") || inputPlayer.equals("PAPER")) { return "LIZARD"; }
            if (inputPlayer.equals("LIZARD")) { return "SCISSORS"; }
        }
        return "Invalid CPU response!";
    }

    public static void endGameOrNewGame(NewGame_SLExtension newGame) {
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

    //process graphics
    public static void graphics(boolean on, boolean color, String roundWinner, String choicePlayer, String choiceCPU) {
        String winnerWeapon = "unknown";
        String loserWeapon = "unknown";
        if (roundWinner.equals("playerWins")) {
            winnerWeapon = choicePlayer;
            loserWeapon = choiceCPU;
        } else if (roundWinner.equals("CPUWins")) {
            winnerWeapon = choiceCPU;
            loserWeapon = choicePlayer;
        }

        if (on) {
            if (color) {
                print256(winnerWeapon);
            } else {
                printBW(winnerWeapon);
            }
            printActionOnBeatenWeapon(winnerWeapon, loserWeapon);
        }
    }

    private static void printBW(String weapon) {
        GraphicsASCII graphicsASCII = new GraphicsASCII();

        switch (weapon) {
            case "ROCK":
                graphicsASCII.rockBW();
                break;
            case "PAPER":
                graphicsASCII.paperBW();
                break;
            case "SCISSORS":
                graphicsASCII.scissorsBW();
                break;
            case "SPOCK":
                graphicsASCII.spockBW();
                break;
            case "LIZARD":
                graphicsASCII.lizardBW();
                break;
        }
    }

    private static void print256(String weapon) {
        GraphicsASCII graphicsASCII = new GraphicsASCII();

        switch (weapon) {
            case "ROCK":
                graphicsASCII.rock256();
                break;
            case "PAPER":
                graphicsASCII.paper256();
                break;
            case "SCISSORS":
                graphicsASCII.scissors256();
                break;
            case "SPOCK":
                graphicsASCII.spock256();
                break;
            case "LIZARD":
                graphicsASCII.lizard256();
                break;
        }
    }

    private static void printActionOnBeatenWeapon(String weaponWinner, String weaponLoser) {
        BannersASCII bannersASCII = new BannersASCII();

        //ROCK
        if (weaponWinner.equals("ROCK") && weaponLoser.equals("SCISSORS")) {
            bannersASCII.crushesActionText();
            bannersASCII.scissorsText();
        }

        if (weaponWinner.equals("ROCK") && weaponLoser.equals("LIZARD")) {
            bannersASCII.crushesActionText();
            bannersASCII.lizardText();
        }

        //SCISSORS
        if (weaponWinner.equals("SCISSORS") && weaponLoser.equals("PAPER")) {
            bannersASCII.cutsActionText();
            bannersASCII.paperText();
        }

        if (weaponWinner.equals("SCISSORS") && weaponLoser.equals("LIZARD")) {
            bannersASCII.decapitatesActionText();
            bannersASCII.lizardText();
        }

        //PAPER
        if (weaponWinner.equals("PAPER") && weaponLoser.equals("ROCK")) {
            bannersASCII.coversActionText();
            bannersASCII.rockText();
        }

        if (weaponWinner.equals("PAPER") && weaponLoser.equals("SPOCK")) {
            bannersASCII.disprovesActionText();
            bannersASCII.spockText();
        }

        //SPOCK
        if (weaponWinner.equals("SPOCK") && weaponLoser.equals("SCISSORS")) {
            bannersASCII.smashesActionText();
            bannersASCII.scissorsText();
        }

        if (weaponWinner.equals("SPOCK") && weaponLoser.equals("ROCK")) {
            bannersASCII.vaporizesActionText();
            bannersASCII.rockText();
        }

        //LIZARD
        if (weaponWinner.equals("LIZARD") && weaponLoser.equals("PAPER")) {
            bannersASCII.eatsActionText();
            bannersASCII.paperText();
        }

        if (weaponWinner.equals("LIZARD") && weaponLoser.equals("SPOCK")) {
            bannersASCII.poisonsActionText();
            bannersASCII.spockText();
        }
    }


}
