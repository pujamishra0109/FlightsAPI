package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

/**
 * Created by Puja on 29/02/20.
 */
public class FlightServicesRequest {

   private CrazyAirRequest crazyAirRequest;
   private ToughJetRequest toughJetRequest;

 public FlightServicesRequest(CrazyAirRequest crazyAirRequest, ToughJetRequest toughJetRequest) {
  this.crazyAirRequest = crazyAirRequest;
  this.toughJetRequest = toughJetRequest;
 }
 public FlightServicesRequest(CrazyAirRequest crazyAirRequest) {
  this.crazyAirRequest = crazyAirRequest;
 }

 public FlightServicesRequest(ToughJetRequest toughJetRequest) {
  this.toughJetRequest = toughJetRequest;
 }


 public CrazyAirRequest getCrazyAirRequest() {
  return crazyAirRequest;
 }

 public void setCrazyAirRequest(CrazyAirRequest crazyAirRequest) {
  this.crazyAirRequest = crazyAirRequest;
 }

 public ToughJetRequest getToughJetRequest() {
  return toughJetRequest;
 }

 public void setToughJetRequest(ToughJetRequest toughJetRequest) {
  this.toughJetRequest = toughJetRequest;
 }
}
