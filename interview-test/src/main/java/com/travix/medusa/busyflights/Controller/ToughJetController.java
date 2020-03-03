package com.travix.medusa.busyflights.Controller;

import com.travix.medusa.busyflights.Service.ToughJetService;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Puja on 28/02/20.
 */
@ComponentScan
@RestController
public class ToughJetController {

    @Autowired
    ToughJetService toughJetService;


    @Validated
    @RequestMapping(value = "/toughjet/flights", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ToughJetResponse>> toughJetFlights(@Valid ToughJetRequest toughJetRequest) throws Exception {

        List<ToughJetResponse>result=new ArrayList<>();
        ResponseEntity<List<ToughJetResponse>> responseEntity= toughJetService.getToughJet(toughJetRequest);

        if(responseEntity.getBody().size()==0)
            return new ResponseEntity<List<ToughJetResponse>>(result, HttpStatus.NO_CONTENT);

        return responseEntity;

    }
}
