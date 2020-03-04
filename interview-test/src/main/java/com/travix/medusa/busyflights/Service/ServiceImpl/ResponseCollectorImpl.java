package com.travix.medusa.busyflights.Service.ServiceImpl;

import com.travix.medusa.busyflights.ConstantData.CrazyAirHelper;
import com.travix.medusa.busyflights.ConstantData.ToughJetHelper;
import com.travix.medusa.busyflights.ConstantData.URL;
import com.travix.medusa.busyflights.Service.ResponseCollector;
import com.travix.medusa.busyflights.Utils.DateUtil;
import com.travix.medusa.busyflights.domain.FlightServicesRequest;
import com.travix.medusa.busyflights.domain.FlightServicesResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Puja on 01/03/20.
 */
@Service
public class ResponseCollectorImpl implements ResponseCollector<FlightServicesResponse> {



    @Override
    public FlightServicesResponse convertSupplierResponse(FlightServicesRequest flightServicesRequest){
        List<ToughJetResponse> toughJetResponseList=getToughJetResponse(flightServicesRequest.getToughJetRequest());

        List<CrazyAirResponse> crazyAirResponseList=getCrazyResponses(flightServicesRequest.getCrazyAirRequest());
                return new FlightServicesResponse(crazyAirResponseList,toughJetResponseList);
    }



    public List<CrazyAirResponse> getCrazyResponses(@Valid CrazyAirRequest crazyAirRequest){
       try {


           RestTemplate restTemplate = new RestTemplate();

           Map<String,String> map=new HashMap<>();
           map.put(CrazyAirHelper.origin,crazyAirRequest.getOrigin());
           map.put(CrazyAirHelper.destination,crazyAirRequest.getDestination());
           map.put(CrazyAirHelper.departureDate,crazyAirRequest.getDepartureDate().toString());
           map.put(CrazyAirHelper.returnDate,crazyAirRequest.getReturnDate().toString());
           map.put(CrazyAirHelper.passengerCount,String.valueOf(crazyAirRequest.getPassengerCount()));

           ResponseEntity<CrazyAirResponse[]> response = restTemplate.getForEntity(URL.CRAZY_AIR_SEARCH_URL,CrazyAirResponse[].class,
                   map);
           System.out.print("crazy air response " +" "+ response.getBody());

           if(response.getStatusCode()!=HttpStatus.OK)
               return new ArrayList<CrazyAirResponse>(null);

           return Arrays.asList(response.getBody());

         }
         catch (HttpStatusCodeException exception) {
            exception.printStackTrace();

        }
        return new ArrayList<CrazyAirResponse>(null);


    }

    public  List<ToughJetResponse> getToughJetResponse(@Valid ToughJetRequest toughJetRequest){

        try {
          RestTemplate restTemplate = new RestTemplate();
         Map<String,String> map=new HashMap<>();
         map.put(ToughJetHelper.from,toughJetRequest.getFrom());
         map.put(ToughJetHelper.to,toughJetRequest.getTo());
         map.put(ToughJetHelper.outboundDate,toughJetRequest.getOutboundDate().toString());
         map.put(ToughJetHelper.inboundDate,toughJetRequest.getInboundDate().toString());
         map.put(ToughJetHelper.numberOfAdults,String.valueOf(toughJetRequest.getNumberOfAdults()));

         ResponseEntity<ToughJetResponse[]> response = restTemplate.getForEntity(URL.TOUGH_JET_SEARCH_URL, ToughJetResponse[].class,
                 map);
          if(response.getStatusCodeValue()!=200)
              return new ArrayList<ToughJetResponse>(null);

          return Arrays.asList(response.getBody());

      } catch (HttpStatusCodeException exception) {
              exception.printStackTrace();

          }
          return new ArrayList<ToughJetResponse>(null);

    }



}
