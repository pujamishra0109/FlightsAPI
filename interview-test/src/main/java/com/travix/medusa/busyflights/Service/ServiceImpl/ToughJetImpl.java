package com.travix.medusa.busyflights.Service.ServiceImpl;

import com.travix.medusa.busyflights.ConstantData.ToughJetHelper;
import com.travix.medusa.busyflights.Service.ToughJetService;
import com.travix.medusa.busyflights.Utils.DataValidator;
import com.travix.medusa.busyflights.Utils.DateUtil;
import com.travix.medusa.busyflights.Utils.DateValidator;
import com.travix.medusa.busyflights.InputData.ToughJetData;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Puja on 29/02/20.
 */
@Service
public class ToughJetImpl implements ToughJetService {
    private static final Logger logger = LoggerFactory.getLogger(CrazyAirServiceImpl.class);

    @Override
    public ResponseEntity<List<ToughJetResponse>> getToughJet(ToughJetRequest toughJetRequest) throws Exception{

        DataValidator.isValid(toughJetRequest.getFrom(),toughJetRequest.getTo(),toughJetRequest.
                getOutboundDate(),toughJetRequest.getInboundDate(),toughJetRequest.getNumberOfAdults());

        List<ToughJetResponse> result=new ArrayList<>();


        List<ToughJetData> list= ToughJetHelper.getAllToughJetDate();
        LocalDate departDateReq= toughJetRequest.getOutboundDate();
        LocalDate arrivalDateReq= toughJetRequest.getInboundDate();

        for(ToughJetData toughJetResponse : list){

           try{
               logger.debug("Departure date "+ toughJetResponse.getOutboundDateTime());
               LocalDate departInp=DateUtil.getLocalDateTime(toughJetResponse.getOutboundDateTime()).toLocalDate();
               LocalDate arrivaInp=DateUtil.getLocalDateTime(toughJetResponse.getInboundDateTime()).toLocalDate();
               if(toughJetRequest.getFrom().equalsIgnoreCase(toughJetResponse.getDepartureAirportName()) &&
                       toughJetRequest.getTo().equalsIgnoreCase(toughJetResponse.getArrivalAirportName()) &&
                       departDateReq.equals(departInp) && arrivalDateReq.equals(arrivaInp)
                       && toughJetRequest.getNumberOfAdults()<=toughJetResponse.getNumberOfAdults())

                   result.add(new ToughJetResponse(toughJetResponse.getCarrier(),toughJetResponse.getBasePrice(),toughJetResponse.getTax(),
                           toughJetResponse.getDiscount(),toughJetResponse.getDepartureAirportName(),toughJetResponse.getArrivalAirportName(),
                           toughJetResponse.getOutboundDateTime(),toughJetResponse.getInboundDateTime()));
            }
           catch (Exception e){
               throw  new IllegalArgumentException();
           }

          }
        return new ResponseEntity<List<ToughJetResponse>>(result,HttpStatus.OK);



    }
}


