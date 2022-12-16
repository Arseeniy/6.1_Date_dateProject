package com.arseeniy.dateproject.agecalculator;

import java.time.*;

public class AgeCalculator {
    public static void main(String[] args) {
        LocalDateTime birthDate = LocalDateTime.of(1997, 12, 9, 0, 0);
        LocalDateTime currentDate = LocalDateTime.now();
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        if (birthDate.toLocalTime().getHour() > currentDate.toLocalTime().getHour()) {
            birthDate = birthDate.plusDays(1);
            hours = 24 + Duration.between(birthDate.toLocalTime(), currentDate.toLocalTime()).toHoursPart();
            minutes = 60 + Duration.between(birthDate.toLocalTime(), currentDate.toLocalTime()).toMinutesPart();
            seconds = 60 + Duration.between(birthDate.toLocalTime(), currentDate.toLocalTime()).toSecondsPart();
        } else {
            hours = Duration.between(birthDate.toLocalTime(), currentDate.toLocalTime()).toHoursPart();
            minutes = Duration.between(birthDate.toLocalTime(), currentDate.toLocalTime()).toMinutesPart();
            seconds = Duration.between(birthDate.toLocalTime(), currentDate.toLocalTime()).toSecondsPart();
        }
        long years = Period.between(birthDate.toLocalDate(), currentDate.toLocalDate()).getYears();
        long months = Period.between(birthDate.toLocalDate(), currentDate.toLocalDate()).getMonths();
        long days = Period.between(birthDate.toLocalDate(), currentDate.toLocalDate()).getDays();

        System.out.println(String.format("Возраст на данный момент: %d лет, %d месяцев, %d дней, %d часов, %d минут, %d секунд",
                years, months, days, hours, minutes, seconds));
    }
}
