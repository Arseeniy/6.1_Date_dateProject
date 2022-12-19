package com.arseeniy.dateproject.agecalculator;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {
    public static void main(String[] args) {
        LocalDateTime birthDate = LocalDateTime.of(1997, 12, 9, 0, 0);
        LocalDateTime currentDate = LocalDateTime.now();
        long years = ChronoUnit.YEARS.between(birthDate, currentDate);
        long months = ChronoUnit.MONTHS.between(birthDate, currentDate);
        long days = ChronoUnit.DAYS.between(birthDate, currentDate);
        long hours = ChronoUnit.HOURS.between(birthDate, currentDate);
        long minutes = ChronoUnit.MINUTES.between(birthDate, currentDate);
        long seconds = ChronoUnit.SECONDS.between(birthDate, currentDate);

        System.out.println(String.format("Возраст на данный момент: %d лет, %d месяцев, %d дней, %d часов, %d минут, %d секунд",
                years, months, days, hours, minutes, seconds));
    }
}
