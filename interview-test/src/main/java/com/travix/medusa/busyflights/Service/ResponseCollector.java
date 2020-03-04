package com.travix.medusa.busyflights.Service;

import com.travix.medusa.busyflights.domain.FlightServicesRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Puja on 01/03/20.
 */
@Service
public interface ResponseCollector<FlightServicesResponse> {


    public FlightServicesResponse convertSupplierResponse(FlightServicesRequest flightServicesRequest);
}
