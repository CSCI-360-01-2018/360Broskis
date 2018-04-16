/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.radioModule;

//import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Austin
 */
public class Radio {
    private Station station = new Station();
    private boolean active;
    private Map<Double,Station> stations;

    /*
    When radio is created, instantiate stations and add to hashmap to avoid duplicates.
    4 stations for purpose of showcasing radio functionality. 2 FM 2 AM
    */
    public Radio() {
        
        stations = new HashMap<>();
        int amfreq = 750;
        double dAmFreq;
        Station sta = new Station(102.7, "FM");
        sta.setMedia("ghostdivision.mp3");
        sta.setMediaPlayer();
        stations.put(102.7, sta);
        sta = new Station(103.5, "FM");
        sta.setMedia("legionofmonsters.mp3");
        sta.setMediaPlayer();
        stations.put(103.5, sta);
        amfreq = 750;
        dAmFreq = amfreq;
        sta = new Station(dAmFreq, "AM");
        sta.setMedia("saygoodbye.mp3");
        sta.setMediaPlayer();
        stations.put(sta.getFrequency(), sta);
        amfreq = 1030;
        dAmFreq = amfreq;
        sta = new Station(dAmFreq, "AM");
        sta.setMedia("messengerofgod.mp3");
        sta.setMediaPlayer();
        stations.put(sta.getFrequency(), sta);
    }
    
    // Set the 'active' state of the radio (on / off)
    public void setActive(boolean Active) {
        active = Active;
    }
    
    // Get the 'active' state of the radio (on / off)
    public boolean getActive() {
        return active;
    }
    
    // Find the specified station by FREQUENCY in the hash map containing stations.
    public Station findStation(double key) {
        return stations.get(key);
    }
}
