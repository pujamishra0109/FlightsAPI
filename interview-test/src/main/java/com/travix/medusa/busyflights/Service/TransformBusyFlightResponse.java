package com.travix.medusa.busyflights.Service;

import com.travix.medusa.busyflights.domain.FlightServicesResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Puja on 01/03/20.
 */
@Service
public interface TransformBusyFlightResponse {

    public List<BusyFlightsResponse> convertToBusyFlight(FlightServicesResponse flightServicesResponse);

}
