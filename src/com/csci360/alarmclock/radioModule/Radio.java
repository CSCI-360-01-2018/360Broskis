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
    boolean active;
    
    public Radio(){
        
    }
    
    public void setActive(boolean Active){
        active = Active;
    }
    
    public void setVolume(int volume){
        this.volume.setVolume(volume);
    }
    
    public void setStation(Station station){
        this.station.setStation(station.getFrequency());
    }
    
}
