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
        long diffInDays = 0;
        if(firstDate.isBefore(secondDate)){
            diffInDays = ChronoUnit.DAYS.between(firstDate, secondDate);
        }else {
            diffInDays = ChronoUnit.DAYS.between(secondDate, firstDate);
        }
        System.out.println(String.format("Разница в днях между датами: %d", diffInDays));
    }
}
