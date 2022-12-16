package com.arseeniy.dateproject.stringconverter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class StringDateConverter {
    public static void main(String[] args) {
        String initial = "Friday, Aug 10, 2016 12:10:56 PM";
        String timeZone = "2016-08-16T10:15:30+08:00";
        System.out.println(stringConverter(initial));
        System.out.println(stringConverterWithTimeZone(timeZone));

    }

    public static String stringConverter(String initStr) {
        int monthStart = initStr.indexOf(" ") + 1;
        int monthEnd = initStr.indexOf(" ", monthStart);
        int dayStart = monthEnd + 1;
        int dayEnd = initStr.indexOf(",", dayStart);
        int yearStart = dayEnd + 2;
        int yearEnd = initStr.indexOf(" ", yearStart + 1);
        String month = initStr.substring(monthStart, monthEnd);
        String day = initStr.substring(dayStart, dayEnd);
        String year = initStr.substring(yearStart, yearEnd);
        String result = day + "-" + month + "-" + year;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy").withLocale(Locale.ENGLISH);
        LocalDate date = LocalDate.parse(result, formatter);
        return String.valueOf(date);
    }

    public static String stringConverterWithTimeZone(String initStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        initStr = initStr.replaceAll("T", " ");
        initStr = initStr.replaceAll("[+]", " +");
        ZonedDateTime zoneWithOffset = ZonedDateTime.parse(initStr, formatter);
        ZonedDateTime currentZone = zoneWithOffset.withZoneSameInstant(ZoneId.systemDefault());
        return currentZone.toString();
    }
}
