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
public class Alarm {
    private int hour,minute;
    private String amPm;
    private String toneTest;
    private boolean active;
    private Media tone;
    private String info;
    private boolean testPlaying;
    File file=new File("alarmSound.mp3");
    Media m = new Media(file.toURI().toString());
    MediaPlayer player = new MediaPlayer(m);
    

    public void setAlarmTime(int hr, int min, String amPm) {
        if(hr >= 13){
            System.out.println("Invalid Hour");
            hr = 12;
        }
        if(min >= 60 || min < 0){
            System.out.println("Invalid Minuite");
            min = 0;
        }
        if(!(amPm.equals("AM") || amPm.equals("PM"))){
            System.out.println("Invalid AM/PM");
            amPm = "AM";
        }
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
        m = file;
    }

    public Media getTone() {
        return m;
    }
    
    public boolean getActive() {
        return active;
    }
    public void testAlarm(){
        if(!testPlaying) {
            player = new MediaPlayer(m);
            player.play(); 
        }
        testPlaying = true;
    }
    
    public MediaPlayer getMediaPlayer() {
        return player;
    }
    
    public void setVolume(Double vol) {
        player.setVolume(vol);
    }
    
    public boolean getTestPlaying() {
        return testPlaying;
    }
    
    public void setTestPlaying(boolean test) {
        testPlaying = test;
    }

    public void startAlarm() {
        System.out.println("Ring is Called");
        if(active) {
        //System.out.println("Wake up");
            player = new MediaPlayer(m);
            player.play(); 
        }
    }
    
    public void stopAlarm(){
        player.stop();
    }
    
    public void snoozeAlarm(){
        stopAlarm();
        minute += 5;
         if (minute >= 60){
            minute = minute - 60;
            hour++;
        }
         if(hour == 13){
            if (amPm.equals("AM")){
                amPm = "PM";
            }
            else{
                amPm = "AM";
            }
            hour = 1;
        }
    }
    
    public void alignTime() {
        if(hour > 12){
            hour %= 12;
            //switchAMPM(amPm);
        }
    }
    private void switchAMPM(String amPM) {
        if(amPM.equals("AM")) {
            amPm = "PM";
        }
        else if(amPM.equals("PM")) {
            amPm = "AM";
        }
    }

}
