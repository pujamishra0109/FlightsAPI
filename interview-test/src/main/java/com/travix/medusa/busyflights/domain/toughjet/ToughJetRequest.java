package com.travix.medusa.busyflights.domain.toughjet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travix.medusa.busyflights.Utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ToughJetRequest {
    @NotNull(message = "origin needs to be filled")
    @Size(min = 3, max = 3, message = "should have 3 characters")
    @JsonProperty("from")
    private String from;

    @NotNull(message = "destination needs to be filled")
    @Size(min = 3, max = 3, message = "should have 3 characters")

    @JsonProperty("to")
    private String to;

    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    @NotNull(message = "departureDate needs to be filled")
    @JsonProperty("outboundDate")
    private LocalDate outboundDate;

    @DateTimeFormat(pattern = DateUtil.ISO_LOCAL_DATE)
    @NotNull(message = "returnDate needs to be filled")

    @JsonProperty("inboundDate")
    private LocalDate inboundDate;

    @NotNull(message = "number of passengers can not be blank")
    @Max(value = 4, message = "numberOfPassengers cannot be greater than 4")

    @JsonProperty("numberOfAdults")
    private int numberOfAdults;
    public ToughJetRequest(){

    }

    public ToughJetRequest(String from, String to, LocalDate outboundDate, LocalDate inboundDate, int numberOfAdults) {
        this.from = from;
        this.to = to;
        this.outboundDate = outboundDate;
        this.inboundDate = inboundDate;
        this.numberOfAdults = numberOfAdults;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public LocalDate getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final LocalDate outboundDate) {
        this.outboundDate = outboundDate;
    }

    public LocalDate getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final LocalDate inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public String toString() {
        return "ToughJetRequest{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", outboundDate=" + outboundDate +
                ", inboundDate=" + inboundDate +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }
}
