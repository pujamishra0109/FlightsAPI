package com.travix.medusa.busyflights.InputData;

import java.time.LocalDate;

/**
 * Created by Puja on 02/03/20.
 */
public class CrazyAirInput {
    private String airline;
    private double price;
    private String cabinclass;

    public CrazyAirInput(String airline, double price, String cabinclass, String departureAirportCode, String destinationAirportCode, String departureDate, String arrivalDate, int passengerCount) {
        this.airline = airline;
        this.price = price;
        this.cabinclass = cabinclass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengerCount = passengerCount;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String arrivalDate;
    private int passengerCount;

    @Override
    public String toString() {
        return "CrazyAirInput{" +
                "airline='" + airline + '\'' +
                ", price=" + price +
                ", cabinclass='" + cabinclass + '\'' +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", passengerCount=" + passengerCount +
                '}';
    }
}
