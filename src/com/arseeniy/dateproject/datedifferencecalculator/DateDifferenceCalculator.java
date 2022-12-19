package com.arseeniy.dateproject.datedifferencecalculator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateDifferenceCalculator {
    public static void main(String[] args) {
        String firstVar = "25.07.1921";
        String secondVar = "12.06.2000";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate firstDate = LocalDate.parse(firstVar, formatter);
        LocalDate secondDate = LocalDate.parse(secondVar, formatter);
        long diffInDays = getDifference(firstDate, secondDate);
        System.out.println(String.format("Разница в днях между датами: %d", diffInDays));
    }

    private static long getDifference(LocalDate firstDate, LocalDate secondDate) {
        return firstDate.isBefore(secondDate) ? ChronoUnit.DAYS.between(firstDate, secondDate) :
                ChronoUnit.DECADES.between(secondDate, firstDate);
    }
}
