/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.clockModule;
import com.csci360.alarmclock.clockModule.Clock;
import java.io.File;
  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer; 



//The alarm class contains all the functionality of our alarm instances in the clock.
public class Alarm {
    
    //hour, minute, and amPm are our main alarm variables.
    private int hour,minute;
    private String amPm;
    //Active keeps track of the alarm is active or not
    private boolean active;
    //info contains the current hour,minute, and amPm of Alarm. To return to UI
    private String info;
    //boolean for testing purposes
    private boolean testPlaying;
    
    //These next few lines set our default alarm tone. You can change it with methods below
    File file=new File("alarmSound.mp3");
    Media m = new Media(file.toURI().toString());
    MediaPlayer player = new MediaPlayer(m);
    
    //Set alarm time takes in 3 parameters and sets them to hour,min,ampm accordingly. 
    //The Controller has its own invalid input handlers (it almost works).
    //The error handling in setAlarmtime prevents invalid hour, min, ampm. 
    //Assuming they are integers and strings accordingly.
    public void setAlarmTime(int hr, int min, String amPm) {
        //System.out.println(amPm);
        //Hour can't be over 13
        if(hr >= 13){
            System.out.println("Invalid Hour");
            hr = 12;
        }
        //Min is invalid if its over 60 or below 0
        if(min >= 60 || min < 0){
            System.out.println("Invalid Minuite");
            min = 0;
        }
        //sets variables accoringly
        hour = hr;
        minute = min;
        this.amPm = amPm;
    }
    //Sets the alarm active so that when startAlarm() is called, the tone will play
    public void activateAlarm(boolean active) {
        this.active = active;
    }
    //Returns the alarminfo in a string format for the UI
    public String getAlarmInfo() {
        if(minute<10){
            info = String.format("%d:0%d %s",hour,minute,amPm, active);
        }
        else{
            info = String.format("%d:%d %s",hour,minute,amPm, active);
        }
         return info;
    }
    //Getter methods for testing purposes
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    
    //
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
    public void testAlarm() {
        
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
        //System.out.println("Ring is Called");
        if(active) {
        //System.out.println("Wake up");
            player = new MediaPlayer(m);
            player.play(); 
        }
    }
    
    public void stopAlarm() {
        player.stop();
    }
    
    public void snoozeAlarm() {
        stopAlarm();
        minute += 5;
         if (minute >= 60) {
            minute = minute - 60;
            hour++;
        }
         if(hour == 13) {
            if (amPm.equals("AM")) {
                amPm = "PM";
            }
            else {
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
}
