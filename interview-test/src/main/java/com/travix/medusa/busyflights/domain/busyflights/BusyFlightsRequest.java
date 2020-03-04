package com.travix.medusa.busyflights.domain.busyflights;

import com.travix.medusa.busyflights.Utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


public class BusyFlightsRequest {



    @NotNull(message = "Origin is missing")
    @Size(min = 3, max = 3, message = " origin should have 3 characters")
    private String origin;
    @NotNull(message = "Destination is missing")
    @Size(min = 3, max = 3, message = "Destination should have 3 characters")
    private String destination;

    //removed the String type from date to take LocalDate as the type
    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    @NotNull(message = "DepatureDate needs to be filled")
    private LocalDate departureDate;

    //removed the String type from date to take LocalDate as the type
    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    @NotNull(message = "ReturnDate needs to be filled")
    private LocalDate returnDate;

    @NotNull(message = "Number of Passengers can not be blank")
    @Max(value = 4, message = "numberOfPassengers cannot be greater than 4")
    private int numberOfPassengers;

    public BusyFlightsRequest(){}

    public BusyFlightsRequest(String origin, String destination, LocalDate departureDate, LocalDate returnDate, int numberOfPassengers) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "BusyFlightsRequest{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
