package com.travix.medusa.busyflights.Service.ServiceImpl;

import com.travix.medusa.busyflights.ConstantData.CrazyAirHelper;
import com.travix.medusa.busyflights.Service.CrazyAirService;
import com.travix.medusa.busyflights.Utils.DataValidator;
import com.travix.medusa.busyflights.Utils.DateUtil;
import com.travix.medusa.busyflights.Utils.DateValidator;
import com.travix.medusa.busyflights.InputData.CrazyAirInput;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Puja on 28/02/20.
 */
@Service
public class CrazyAirServiceImpl implements CrazyAirService {

    private static final Logger logger = LoggerFactory.getLogger(CrazyAirServiceImpl.class);


    @Override
    public ResponseEntity<List<CrazyAirResponse>> getCrazyAir(CrazyAirRequest crazyAirRequest) throws Exception{
        DataValidator.isValid(crazyAirRequest.getOrigin(),crazyAirRequest.getDestination(),crazyAirRequest.
                getDepartureDate(),crazyAirRequest.getReturnDate(),crazyAirRequest.getPassengerCount());

        List<CrazyAirInput> list= CrazyAirHelper.getAllCrazyAirInput();
        List<CrazyAirResponse> result=new ArrayList<>();


        for(CrazyAirInput crazyAirResponse : list){

            try{
                logger.debug("Departure date "+ crazyAirResponse.getDepartureDate());
              LocalDate departure=DateUtil.getLocalDateTime(crazyAirResponse.getDepartureDate()).toLocalDate();
                LocalDate arrival=DateUtil.getLocalDateTime(crazyAirResponse.getArrivalDate()).toLocalDate();
                 if(crazyAirRequest.getOrigin().equalsIgnoreCase(crazyAirResponse.getDepartureAirportCode()) &&
                    crazyAirRequest.getDestination().equalsIgnoreCase(crazyAirResponse.getDestinationAirportCode())
                        && (departure.compareTo(crazyAirRequest.getDepartureDate())==0) &&
                        (arrival.compareTo(crazyAirRequest.getReturnDate())==0)
                         && crazyAirResponse.getPassengerCount()>=crazyAirRequest.getPassengerCount())
                result.add(new CrazyAirResponse(crazyAirResponse.getAirline(),crazyAirResponse.getPrice(),crazyAirResponse.getCabinclass(),
                        crazyAirResponse.getDepartureAirportCode(),crazyAirResponse.getDestinationAirportCode(),crazyAirResponse.getDepartureDate(),
                        crazyAirResponse.getArrivalDate()));


            }
            catch (Exception e){
                throw  new IllegalArgumentException();
            }

        }
        return new ResponseEntity<List<CrazyAirResponse>>(result,HttpStatus.OK);



    }
}
