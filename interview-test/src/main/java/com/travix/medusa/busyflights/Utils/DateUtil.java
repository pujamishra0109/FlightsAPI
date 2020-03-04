package com.travix.medusa.busyflights.Utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Puja on 29/02/20.
 */
public class DateUtil
{
    public static final String ISO_LOCAL_DATE = "yyyy-MM-dd";

    public static LocalDate localDate=LocalDate.now();


    public static LocalDate getLocalDate(String s){
        return LocalDate.parse(s,DateTimeFormatter.ISO_DATE);

    }

    public static LocalDateTime getLocalDateTime(String s){
        return LocalDateTime.parse(s,DateTimeFormatter.ISO_DATE_TIME);
    }
    public static String getInstantToDateTime(String in) {
        LocalDateTime localDateTime = LocalDateTime.parse(in,DateTimeFormatter.ISO_DATE_TIME);
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public static String getLocalDateTimeToDateTime(String in) {
        LocalDateTime localDateTime = LocalDateTime.parse(in, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

}
