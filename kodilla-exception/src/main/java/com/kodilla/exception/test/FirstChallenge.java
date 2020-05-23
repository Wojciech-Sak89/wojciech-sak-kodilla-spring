package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if(b == 0){
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        double result = -1d;

        try {
            result = firstChallenge.divide(3, 0);
        } catch (ArithmeticException e) {
            System.out.println("Don't divide by zero! Exception: " + e);
        } finally {
            System.out.println(result);
        }




    }

}
