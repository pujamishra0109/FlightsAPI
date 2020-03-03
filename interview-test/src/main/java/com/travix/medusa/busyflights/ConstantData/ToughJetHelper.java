package com.travix.medusa.busyflights.ConstantData;

import com.travix.medusa.busyflights.InputData.ToughJetData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Puja on 29/02/20.
 */
public class ToughJetHelper {
   public static String from="from";
    public static String to="to";
    public static String outboundDate="outboundDate";
    public static String inboundDate="inboundDate";
    public static String numberOfAdults="numberOfAdults";


    public static List<ToughJetData> getAllToughJetDate(){

        List<ToughJetData> out = new ArrayList<>();
//        out.add(new ToughJetData("Booking", 12.21d, 10.12d, 10.00d, "Ams", "Par", "2010-01-08T11:44:44.797", "2010-01-09T11:44:44.797",3));
//        out.add(new ToughJetData("Makemytrip", 50.21d, 30.32d, 15.01d, "Ams", "Par", "2010-01-08T11:44:44.797", "2010-01-09T11:44:44.797",4));
//        out.add(new ToughJetData("TripAdvisor", 9.10d,23.58d, 5.32d, "Ams", "Par", "2010-01-08T11:44:44.797", "2010-01-09T11:44:44.797",4));
        out.add(new ToughJetData("KLM",95,18,15,"AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",8));
        out.add(new ToughJetData("KLM",164,17,11,"AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",10));
        out.add(new ToughJetData("KLM",84,14,18,"AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",8));
        out.add(new ToughJetData("KLM",297,10,17,"PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",5));
        out.add(new ToughJetData("KLM",386,13,12,"LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",8));
        out.add(new ToughJetData("EasyJet",258,18,19,"AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",6));
        out.add(new ToughJetData("EasyJet",51,16,11,"AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",8));
        out.add(new ToughJetData("EasyJet",192,15,18,"AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",7));
        out.add(new ToughJetData("EasyJet",312,12,20,"PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",5));
        out.add(new ToughJetData("EasyJet",107,18,15,"LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",3));
        out.add(new ToughJetData("Transavia",210,11,16,"AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",8));
        out.add(new ToughJetData("Transavia",168,11,16,"AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",7));
        out.add(new ToughJetData("Transavia",355,11,16,"AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",1));
        out.add(new ToughJetData("Transavia",341,14,12,"PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",3));
        out.add(new ToughJetData("Transavia",83,20,17,"LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",5));
        out.add(new ToughJetData("Emirates",281,10,13,"AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",3));
        out.add(new ToughJetData("Emirates",129,18,13,"AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",1));
        out.add(new ToughJetData("Emirates",147,19,13,"AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",2));
        out.add(new ToughJetData("Emirates",140,12,16,"PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",9));
        out.add(new ToughJetData("Emirates",379,20,10,"LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",5));
        out.add(new ToughJetData("Etihad",367,19,15,"AMS","LON","2020-03-10T09:10:00.000","2020-03-12T09:10:00.000",10));
        out.add(new ToughJetData("Etihad",377,20,17,"AMS","PAR","2020-03-11T10:10:00.000","2020-03-13T10:10:00.000",10));
        out.add(new ToughJetData("Etihad",184,20,10,"AMS","BOM","2020-03-12T11:10:00.000","2020-03-14T11:10:00.000",5));
        out.add(new ToughJetData("Etihad",310,19,11,"PAR","AMS","2020-03-13T12:10:00.000","2020-03-15T12:10:00.000",3));
        out.add(new ToughJetData("Etihad",286,13,10,"LON","BRU","2020-03-14T08:10:00.000","2020-03-16T08:10:00.000",1));
        return out;
    }

}
