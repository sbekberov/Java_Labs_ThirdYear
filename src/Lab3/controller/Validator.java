package Lab3.controller;

import Lab3.controller.exceptions.FutureYearException;
import Lab3.controller.exceptions.NegativeNumberException;

import java.util.Calendar;

public class Validator {

    public static void validateYearValue(int year) {
        if (year < 0) {
            throw new NegativeNumberException();
        }
        if (year > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new FutureYearException();
        }

    }

    public static void validateDoubleValue(double price) {
        if (price < 0) {
            throw new NegativeNumberException();
        }

    }
}