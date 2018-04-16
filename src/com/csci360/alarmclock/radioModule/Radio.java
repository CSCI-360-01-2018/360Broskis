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
    //private Volume volume = new Volume();
    private boolean active;
    private Map<Double,Station> stations;

    public Radio() {
        //stations = new HashMap();
        stations = new HashMap<>();
        int amfreq = 750;
        double dAmFreq = amfreq;
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
    
    public void setActive(boolean Active) {
        active = Active;
    }
    
    public boolean getActive() {
        return active;
    }

    public void setVolume(Station sta, Double vol) {
        sta.setVolume(vol);
    }
    
    public double getVolume(Station sta) {
        return sta.getVolume();
    }
    
    /*
    public void setStation(Station station) {
        this.station.setStation(station.getFrequency());
    }
    
    public double getStation() {
        return station.getFrequency();
    }
    */
    public Station findStation(double key) {
        return stations.get(key);
    }
}
