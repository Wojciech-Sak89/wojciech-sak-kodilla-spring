package com.kodilla.rps.extension;

public class Instructions {
    public static void printInstructions() {
        System.out.println("ROCK PAPER SCISSORS SPOCK LIZARD - THE GAME\n" +
                "Hello! Here you have an opportunity to play a modified version of classic game known as ROCK PAPER SCISSORS!\n" +
                "It adds to the original game new weapons: SPOCK and LIZARD" +
                "\n");
        printControls();
        printWhatBeatsWhat();
        System.out.println("\nAfter you type 1-5 or name of the weapon (\"rock\", \"spock\", etc.), the CPU will respond. " +
                "\nDon't worry, it doesn't know what you have chosen (or is it...), like in real game! :-)\n");
    }

    public static void printControls() {
        System.out.println("CONTROLS\n" +
                "After choosing number of rounds needed to win the game enter:\n" +
                "1 (or \"rock\") - to play ROCK\n" +
                "2 (or \"paper\")- to play PAPER\n" +
                "3 (or \"scissors\") - to play SCISSORS\n" +
                "4 (or \"spock\") - to play SPOCK\n" +
                "5 (or \"lizard\") - to play LIZARD\n" +
                "x - to end the game\n" +
                "n - to start a new game\n" +
                "c - to see controls\n" +
                "h - to see what beats what\n");
    }

    public static void printWhatBeatsWhat() {
        System.out.println("WHAT BEATS WHAT?" +
                "\nROCK: crushes SCISSORS and crushes LIZARD " +
                "\nSCISSORS: cuts PAPER and decapitates LIZARD" +
                "\nPAPER: covers ROCK and disproves SPOCK" +
                "\nSPOCK: smashes SCISSORS and vaporizes ROCK" +
                "\nLIZARD: eats PAPER and poisons SPOCK\n");
    }
}
