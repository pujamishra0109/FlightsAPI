package com.travix.medusa.busyflights.Utils;

import com.sun.media.sound.InvalidDataException;
import com.travix.medusa.busyflights.domain.FlightServicesRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Created by Puja on 02/03/20.
 */
public class DataValidator {

    public static void isValid(String origin,String dest,LocalDate departureDate,LocalDate arrivalDate,int passengers) throws InvalidDataException {

        if(!DateValidator.validDates(departureDate,arrivalDate))
            throw new InvalidDataException("Dates entered are past dates");

        if(!DateValidator.correctArrivalDepartDates(departureDate,arrivalDate))
            throw new InvalidDataException("Arrival Date is before Departure Date");


        if((origin==null || origin=="") ||
                (dest==null || dest==""))
        throw new InvalidDataException("Invalid Origin/Destination ");

        if(Objects.isNull(departureDate)||
                Objects.isNull(arrivalDate))
            throw new InvalidDataException("Invalid Origin/Destination Date");


        if(origin.length()!=3 ||dest.length()!=3)
            throw new InvalidDataException("Origin/Destination code should be of 3 Characters");


        if(passengers<1 || passengers>4)
            throw new InvalidDataException("Invalid Number of Passengers");
    }
}
