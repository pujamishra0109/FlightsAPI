package com.travix.medusa.busyflights.Service.ServiceImpl;

import com.travix.medusa.busyflights.Service.BusyFlightServices;
import com.travix.medusa.busyflights.Service.TransformBusyFlightResponse;
import com.travix.medusa.busyflights.Utils.CustomComparator;
import com.travix.medusa.busyflights.Utils.DateUtil;
import com.travix.medusa.busyflights.domain.FlightServicesResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Puja on 01/03/20.
 */
@Service
public class TransformBusyFlightImpl implements TransformBusyFlightResponse {


    @Value("${crazyairline}")
    private String crazyair;

    @Value("${toughjet}")
    private String toughjet;

    public List<BusyFlightsResponse> convertToBusyFlight(FlightServicesResponse flightServicesResponse){
        List<BusyFlightsResponse> result=new ArrayList<>();

        for(CrazyAirResponse crazyAirResponse : flightServicesResponse.getCrazyAirResponse()){
           String departureDate=DateUtil.getLocalDateTimeToDateTime(crazyAirResponse.getDepartureDate());
            String arrivalDate=DateUtil.getLocalDateTimeToDateTime(crazyAirResponse.getArrivalDate());
            result.add(new BusyFlightsResponse(crazyAirResponse.getAirline(),crazyair,crazyAirResponse.getPrice(),
                    crazyAirResponse.getDepartureAirportCode(),crazyAirResponse.getDestinationAirportCode()
                    ,departureDate,arrivalDate));
        }
        for(ToughJetResponse toughJetList1 :flightServicesResponse.getToughJetResponse()){

            String departureDate = DateUtil.getInstantToDateTime(toughJetList1.getOutboundDateTime());
            String arrivalDate = DateUtil.getInstantToDateTime(toughJetList1.getInboundDateTime());

            Double fare=Math.round((toughJetList1.getBasePrice()*(1-(toughJetList1.getDiscount())/100)+toughJetList1.getTax())*100.0)/100.0;
            result.add(new BusyFlightsResponse(toughJetList1.getCarrier(),toughjet,
                    fare,toughJetList1.getDepartureAirportName(),toughJetList1.getArrivalAirportName()
                    ,departureDate,arrivalDate));

        }
       return result;
    }

}
