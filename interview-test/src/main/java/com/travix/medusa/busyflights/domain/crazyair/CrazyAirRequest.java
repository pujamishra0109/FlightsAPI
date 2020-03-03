package com.travix.medusa.busyflights.domain.crazyair;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travix.medusa.busyflights.Utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CrazyAirRequest {

    @NotNull(message = "origin needs to be filled")
    @Size(min = 3, max = 3, message = "should have 3 characters")
    @JsonProperty("origin")

    private String origin;

    @NotNull(message = "destination needs to be filled")
    @Size(min = 3, max = 3, message = "should have 3 characters")
    @JsonProperty("destination")

    private String destination;

    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    @NotNull(message = "departureDate needs to be filled")
    @JsonProperty("departureDate")

    private LocalDate departureDate;

    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    @NotNull(message = "returnDate needs to be filled")
    @JsonProperty("returnDate")

    private LocalDate returnDate;

    @NotNull(message = "number of passengers can not be blank")
    @Max(value = 4, message = "numberOfPassengers cannot be greater than 4")
    @JsonProperty("passengerCount")

    private int passengerCount;
    public CrazyAirRequest(){

    }

    public CrazyAirRequest(String origin, String destination, LocalDate departureDate, LocalDate returnDate, int passengerCount) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengerCount = passengerCount;
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

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        return "CrazyAirRequest{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", passengerCount=" + passengerCount +
                '}';
    }
}
