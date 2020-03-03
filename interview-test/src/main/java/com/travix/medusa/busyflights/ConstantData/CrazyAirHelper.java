package com.travix.medusa.busyflights.ConstantData;

import com.travix.medusa.busyflights.InputData.CrazyAirInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Puja on 28/02/20.
 */
public  class CrazyAirHelper {

    public static String origin="origin";
    public static String destination="destination";
    public static String departureDate="departureDate";
    public static String returnDate="returnDate";
    public static String  passengerCount="passengerCount";

    public static List<CrazyAirInput> getAllCrazyAirInput(){
        List<CrazyAirInput> list = new ArrayList<>();
//        list.add(new CrazyAirInput("Air", 10.21d, "E", "Ams", "Par", "2010-01-08T11:44:44.797", "2010-01-09T11:44:44.797",3));
//        list.add(new CrazyAirInput("MakeMyTrip", 190.21, "B", "Ams", "Par", "2010-01-08T11:44:44.797", "2010-01-09T11:44:44.797",4));
//        list.add(new CrazyAirInput("AirBnb", 212.21, "B", "Ams", "Par", "2010-01-08T11:44:44.797", "2017-07-09T11:44:44.797",4));
//        list.add(new CrazyAirInput("TripAdvisor", 160.21, "E", "Ams", "Par", "2010-01-08T11:44:44.797", "2010-01-09T11:44:44.797",3));
//        list.add(new CrazyAirInput("Bookinh", 321.25, "B", "Ams", "Par", "2010-01-09T11:44:44.797",
//                "2010-01-09T11:44:44.797",3));
        list.add(new CrazyAirInput("KLM",382,"B","AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",1));
        list.add(new CrazyAirInput("KLM",220,"E","AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",6));
        list.add(new CrazyAirInput("KLM",399,"B","PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",1));
        list.add(new CrazyAirInput("KLM",262,"E","LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",9));
        list.add(new CrazyAirInput("EasyJet",370,"B","AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",9));
        list.add(new CrazyAirInput("EasyJet",266,"E","AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",7));
        list.add(new CrazyAirInput("EasyJet",344,"B","AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",9));
        list.add(new CrazyAirInput("EasyJet",82,"E","PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",9));
        list.add(new CrazyAirInput("EasyJet",111,"B","LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",7));
        list.add(new CrazyAirInput("Transavia",156,"E","AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",1));
        list.add(new CrazyAirInput("Transavia",66,"B","AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",10));
        list.add(new CrazyAirInput("Transavia",148,"E","AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",4));
        list.add(new CrazyAirInput("Transavia",150,"B","PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",3));
        list.add(new CrazyAirInput("Transavia",260,"E","LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",6));
        list.add(new CrazyAirInput("Emirates",76,"B","AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",4));
        list.add(new CrazyAirInput("Emirates",313,"E","AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",4));
        list.add(new CrazyAirInput("Emirates",242,"B","AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",3));
        list.add(new CrazyAirInput("Emirates",388,"E","PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",1));
        list.add(new CrazyAirInput("Emirates",385,"B","LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",6));
        list.add(new CrazyAirInput("Etihad",127,"E","AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",7));
        list.add(new CrazyAirInput("Etihad",353,"B","AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",1));
        list.add(new CrazyAirInput("Etihad",292,"E","AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",1));
        list.add(new CrazyAirInput("Etihad",140,"B","PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",1));
        list.add(new CrazyAirInput("Etihad",120,"E","LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",3));


        return list;
    }

}
