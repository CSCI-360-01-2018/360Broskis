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
public class Station {
    float freq;
    
    public void setStation(float frequency)
    {
        freq = frequency;
    }
    
    public float getFrequency()
    {
        return freq;
        
        //return 0;
    }
}
