package com.travix.medusa.busyflights.Utils;

import com.sun.media.sound.InvalidDataException;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Puja on 29/02/20.
 */
public class DateValidator {

    public static boolean correctArrivalDepartDates(LocalDate s1, LocalDate s2) {
        return (s1.compareTo(s2)<=0);
    }
    public static boolean validDates(LocalDate s1,LocalDate s2){
        return ((s1.compareTo(DateUtil.localDate)>=0) && (s2.compareTo(DateUtil.localDate)>=0));

    }
}
