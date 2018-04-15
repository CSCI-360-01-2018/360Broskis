/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.clockModule;
import javafx.application.Application;
import com.csci360.alarmclock.clockModule.Clock;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer; 

/**
 *
 * @author Austin
 */
public class Alarm  {
    private int hour,minute;
    private String amPm;
    private String toneTest;
    private boolean active;
    private Media tone;
    private String info;
    
    

    public void setAlarmTime(int hr, int min, String amPm) {
        hour = hr;
        minute = min;
        this.amPm = amPm;
    }

    public void activateAlarm(boolean active) {
        this.active = active;
    }
    public String getAlarmInfo() {
        if(minute<10){
            info = String.format("%d:0%d %s",hour,minute,amPm, active);
        }
        else{
            info = String.format("%d:%d %s",hour,minute,amPm, active);
        }
         return info;
    }

    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }

     public boolean compareTime(Clock clock) {
        return (this.hour == clock.getHour() && this.minute == clock.getMinute());
    }
    public void setTone(Media file) {
        tone = file;
    }

    public Media getTone() {
        return tone;
    }

    public String ring() {
        //System.out.println("Wake up");
        File file=new File("alarmSound.mp3");
        Media m = new Media(file.toURI().toString());
        MediaPlayer player = new MediaPlayer(m);
        
        if (active == true){
            player.play();
        }
        
        toneTest = "Wake up";
        return toneTest;
    }
    
    public void alignTime(){
        if(hour > 12){
            hour %= 12;
            //switchAMPM(amPm);
        }
    }
    private void switchAMPM(String amPM){
        if(amPM.equals("AM")){
            amPm = "PM";
        }
        else if(amPM.equals("PM")){
            amPm = "AM";
        }
    }

}
