package com.travix.medusa.busyflights.Service.ServiceImpl;

import com.travix.medusa.busyflights.Service.*;
import com.travix.medusa.busyflights.Utils.CustomComparator;
import com.travix.medusa.busyflights.Utils.DataValidator;
import com.travix.medusa.busyflights.Utils.DateUtil;
import com.travix.medusa.busyflights.Utils.DateValidator;
import com.travix.medusa.busyflights.domain.FlightServicesRequest;
import com.travix.medusa.busyflights.domain.FlightServicesResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Puja on 29/02/20.
 */
@Service
public class BusyFlightServiceImpl implements BusyFlightServices  {


    @Autowired
    TransformSupplierRequest<FlightServicesRequest> flightServiceRequestTransformSupplierRequest;

    @Autowired
    TransformSupplierResponse<FlightServicesResponse> transformSupplierResponse;

    @Autowired
    TransformBusyFlightResponse transformBusyFlightResponse;




    public ResponseEntity<List<BusyFlightsResponse>> getBusyFlightService(BusyFlightsRequest busyFlightsRequest) throws Exception{
        DataValidator.isValid(busyFlightsRequest.getOrigin(),busyFlightsRequest.getDestination(),busyFlightsRequest.
                getDepartureDate(),busyFlightsRequest.getReturnDate(),busyFlightsRequest.getNumberOfPassengers());


        List<BusyFlightsResponse> result=new ArrayList<>();


        FlightServicesRequest flightServicesRequest=flightServiceRequestTransformSupplierRequest.convertRequest(busyFlightsRequest);

        FlightServicesResponse flightServicesResponse=transformSupplierResponse.convertSupplierResponse(flightServicesRequest);


         result=transformBusyFlightResponse.convertToBusyFlight(flightServicesResponse);
        Collections.sort(result,new CustomComparator());

        return new ResponseEntity<List<BusyFlightsResponse>>(result, HttpStatus.OK);
    }


}
