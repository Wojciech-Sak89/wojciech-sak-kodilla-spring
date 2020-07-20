package com.kodilla.hibernate.manytomany.facade;

public class RetrievingException extends Exception {

    public static String ERR_NO_EMPLOYEES_RESULTS = "There are no employees with this string fragment in their last name";
    public static String ERR_NO_COMPANIES_RESULTS = "There are no companies with this string fragment in their name";

    public RetrievingException(String message) {
        super(message);
    }
}
