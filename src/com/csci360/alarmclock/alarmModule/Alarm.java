/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.alarmModule;

import com.csci360.alarmclock.clockModule.Clock;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Austin
 */
public class Alarm extends Clock{
    private int alarmNum,hour,minute;
    private String amPm;
    private String toneTest;
    private boolean active;
    private Media tone;
    
    public void setAlarmTime(int hr, int min){
        hour = hr;
        minute = min;
    }
    
    public void setTone(Media file){
        tone = file;
    }
    
    public Media getTone(){
        return tone;
    }
    
    public String ring(){
        //System.out.println("Wake up");
        toneTest = "Wake up";
        return toneTest;
    }
    
    public boolean compareTime(Clock clock){
        return (this.hour == clock.getHour() && this.minute == clock.getMinute());
    }
    
    

}
