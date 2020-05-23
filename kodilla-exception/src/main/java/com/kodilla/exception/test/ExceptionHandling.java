package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(3, 1));
        } catch (Exception e) {
            System.out.println("So fragile function! Here's an exception: " + e);
        } finally {
            System.out.println("Method probablyIWillThrowException(x, y) returns \"Done!\"? Or maybe \"UnDone!\"? " +
                    "Who cares! Finally works anyway!");
        }

    }
}
