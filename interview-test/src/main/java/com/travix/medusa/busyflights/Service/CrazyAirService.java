package com.travix.medusa.busyflights.Service;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Puja on 28/02/20.
 */
@Service
public interface CrazyAirService {

    public ResponseEntity<List<CrazyAirResponse>> getCrazyAir(CrazyAirRequest crazyAirRequest) throws Exception;

}
