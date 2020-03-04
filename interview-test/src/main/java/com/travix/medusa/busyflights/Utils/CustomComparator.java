package com.travix.medusa.busyflights.Utils;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.Comparator;

/**
 * Created by Puja on 29/02/20.
 */
public class CustomComparator implements Comparator<BusyFlightsResponse> {

    @Override
    public int compare(BusyFlightsResponse busyFlightsResponse1,BusyFlightsResponse busyFlightsResponse2){
        return Double.valueOf(busyFlightsResponse1.getFare()).compareTo(Double.valueOf(busyFlightsResponse2.getFare()));
    }
}
