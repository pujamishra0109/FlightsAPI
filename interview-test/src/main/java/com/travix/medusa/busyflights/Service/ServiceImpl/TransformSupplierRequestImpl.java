package com.travix.medusa.busyflights.Service.ServiceImpl;

import com.travix.medusa.busyflights.Service.TransformSupplierRequest;
import com.travix.medusa.busyflights.Utils.DateUtil;
import com.travix.medusa.busyflights.domain.FlightServicesRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Puja on 01/03/20.
 */
@Service
public class TransformSupplierRequestImpl implements TransformSupplierRequest<FlightServicesRequest> {

    private CrazyAirRequest crazyAirRequest;
    private ToughJetRequest toughJetRequest;

    @Override
    public FlightServicesRequest convertRequest(BusyFlightsRequest busyFlightsRequest) {


        crazyAirRequest = new CrazyAirRequest(busyFlightsRequest.getOrigin(), busyFlightsRequest.getDestination(),
                busyFlightsRequest.getDepartureDate(),busyFlightsRequest.getReturnDate(), busyFlightsRequest.getNumberOfPassengers());

        toughJetRequest=new ToughJetRequest(busyFlightsRequest.getOrigin(),busyFlightsRequest.getDestination(),
                busyFlightsRequest.getDepartureDate(),busyFlightsRequest.getReturnDate(),busyFlightsRequest.getNumberOfPassengers());

        return  new FlightServicesRequest(crazyAirRequest,toughJetRequest);
    }
}
