package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import java.util.List;

/**
 * Created by Puja on 01/03/20.
 */
public class FlightServicesResponse {

    private List<CrazyAirResponse> crazyAirResponse;
    private List<ToughJetResponse> toughJetResponse;

    public FlightServicesResponse(List<CrazyAirResponse> crazyAirResponse, List<ToughJetResponse> toughJetResponse) {
        this.crazyAirResponse = crazyAirResponse;
        this.toughJetResponse = toughJetResponse;
    }



    public List<CrazyAirResponse> getCrazyAirResponse() {
        return crazyAirResponse;
    }

    public void setCrazyAirResponse(List<CrazyAirResponse> crazyAirResponse) {
        this.crazyAirResponse = crazyAirResponse;
    }

    public List<ToughJetResponse> getToughJetResponse() {
        return toughJetResponse;
    }

    public void setToughJetResponse(List<ToughJetResponse> toughJetResponse) {
        this.toughJetResponse = toughJetResponse;
    }
}
