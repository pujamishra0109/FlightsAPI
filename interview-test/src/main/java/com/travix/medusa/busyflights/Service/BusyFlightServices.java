package com.travix.medusa.busyflights.Service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Puja on 29/02/20.
 */
@Service
public interface BusyFlightServices {
    public ResponseEntity<List<BusyFlightsResponse>> getBusyFlightService(BusyFlightsRequest busyFlightsRequest) throws Exception;

}
