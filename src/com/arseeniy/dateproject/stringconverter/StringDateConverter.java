package com.arseeniy.dateproject.stringconverter;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class StringDateConverter {
    public static void main(String[] args) {
        String initial = "Wednesday, Aug 10, 2016 12:10:56 PM";
        String timeZone = "2016-08-16T10:15:30+08:00";
        System.out.println(stringConverter(initial));
        System.out.println(stringConverterWithTimeZone(timeZone));

    }

    public static String stringConverter(String initStr) {

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a").withLocale(Locale.ENGLISH);
        LocalDateTime initialDateTime = LocalDateTime.parse(initStr, formatter1);
        return initialDateTime.toLocalDate().toString();
    }

    public static String stringConverterWithTimeZone(String initStr) {
        ZonedDateTime zoneWithOffset = ZonedDateTime.parse(initStr);
        ZonedDateTime currentZone = zoneWithOffset.withZoneSameInstant(ZoneId.of("Europe/Samara"));
        return currentZone.toString();
    }
}
