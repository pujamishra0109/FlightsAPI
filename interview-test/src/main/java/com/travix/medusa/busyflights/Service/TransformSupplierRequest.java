package com.travix.medusa.busyflights.Service;

import com.travix.medusa.busyflights.domain.FlightServicesRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Puja on 01/03/20.
 */
@Service
public interface TransformSupplierRequest<FlightServiceRequest> {

   public FlightServiceRequest convertRequest(BusyFlightsRequest busyFlightsRequest);

}
