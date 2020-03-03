package com.travix.medusa.busyflights.Controller;

import com.travix.medusa.busyflights.Service.CrazyAirService;
import com.travix.medusa.busyflights.Utils.DataValidator;
import com.travix.medusa.busyflights.Utils.DateUtil;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Puja on 28/02/20.
 */
@ComponentScan
@RestController
public class CrazyAirController {

    private static final Logger logger = LoggerFactory.getLogger(CrazyAirController.class);


    @Autowired
    CrazyAirService crazyAirService;

    @Validated
    @RequestMapping(value = "/crazyflight/flight", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<CrazyAirResponse>> crazyAirResponses(@Valid CrazyAirRequest crazyAirRequest) throws Exception {

        List<CrazyAirResponse> result = new ArrayList<>();

        ResponseEntity<List<CrazyAirResponse>> responseEntity= crazyAirService.getCrazyAir(crazyAirRequest);
        if(responseEntity.getBody().size()==0)
            return new ResponseEntity<List<CrazyAirResponse>>(result, HttpStatus.NO_CONTENT);

        return responseEntity;

    }
}
