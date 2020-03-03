package com.travix.medusa.busyflights.domain;

import java.util.HashMap;

/**
 * Created by Puja on 03/03/20.
 */
public class ErrorMessage {
    private HashMap<String,String> map=new HashMap<>();

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "map=" + map +
                '}';
    }

    public ErrorMessage(HashMap<String, String> map) {
        this.map = map;
    }

    public HashMap<String, String> getMap() {

        return map;
    }

    public void setMap(HashMap<String, String> map) {

        this.map = map;
    }

    public ErrorMessage(String s1, String s2){

        map.put(s1,s2);
    }
}
