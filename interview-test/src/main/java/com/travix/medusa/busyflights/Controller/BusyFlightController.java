package com.travix.medusa.busyflights.Controller;

import com.sun.media.sound.InvalidDataException;
import com.travix.medusa.busyflights.Service.*;
import com.travix.medusa.busyflights.Utils.DataValidator;
import com.travix.medusa.busyflights.Utils.DateUtil;
import com.travix.medusa.busyflights.Utils.DateValidator;
import com.travix.medusa.busyflights.domain.ErrorMessage;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Puja on 29/02/20.
 */
@ComponentScan
@RestController
public class BusyFlightController {

    @Autowired
    BusyFlightServices busyFlightServices;

    @RequestMapping(value = "/busyFlight/flights", method = RequestMethod.GET, produces = "application/json")
    @Validated
    public ResponseEntity<?>  busyFlight (@Valid BusyFlightsRequest busyFlightsRequest,BindingResult bindingResult) throws Exception{

        if(bindingResult.hasErrors()){
            Map<String,String>map=new HashMap<>();

            if(bindingResult.getFieldError().getDefaultMessage().contains("ConversionFailedException"))
                map.put("Error Message","Invalid DateTime Format");
            else
            map.put("Error Message",bindingResult.getFieldError().getDefaultMessage().toString());
            return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
        }
        List<BusyFlightsResponse> result=new ArrayList<>();

        ResponseEntity<List<BusyFlightsResponse>> responseEntity = busyFlightServices.getBusyFlightService(busyFlightsRequest);
        if(responseEntity.getBody().size()==0)
            return new ResponseEntity<List<BusyFlightsResponse>>(result, HttpStatus.NO_CONTENT);
        return responseEntity;
    }

}
