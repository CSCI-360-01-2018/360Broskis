/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.radioModule;

/**
 *
 * @author Austin
 */
public class Radio {

    private Station station;
    private Volume volume;
    private boolean active;

    public Radio() {

    }

    public void setActive(boolean Active) {
        active = Active;
    }
    
    public boolean getActive(){
        return active;
    }

    public void setVolume(int volume) {
        this.volume.setVolume(volume);
    }
    
    public int getVolume(){
        return volume.getVolume();
    }

    public void setStation(Station station) {
        this.station.setStation(station.getFrequency());
    }
    
    public float getStation(){
        return station.getFrequency();
    }
}
