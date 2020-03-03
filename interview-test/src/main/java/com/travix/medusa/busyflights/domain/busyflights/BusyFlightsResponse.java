package com.travix.medusa.busyflights.domain.busyflights;

import java.util.Map;

public class BusyFlightsResponse {

    private  String airline;
    private String supplier;
    private double fare;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private Map<String,String> error;

    public BusyFlightsResponse(){

    }
    public BusyFlightsResponse(Map<String,String>error){
        this.error=error;
    }
    public BusyFlightsResponse(String airline, String supplier, double fare, String origin, String destination, String departureDate, String returnDate) {
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BusyFlightsResponse{" +
                "airline='" + airline + '\'' +
                ", supplier='" + supplier + '\'' +
                ", fare=" + fare +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
