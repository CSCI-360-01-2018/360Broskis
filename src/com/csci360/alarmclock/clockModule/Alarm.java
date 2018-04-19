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
            System.out.println("Invalid Minute");
            min = 0;
        }
        //sets variables accoringly
        hour = hr;
        minute = min;
        
        if (!(amPm.equals("AM") || amPm.equals("PM"))){
            System.out.println("Invalid AM/PM");
            
        }
        else{
             this.amPm = amPm;
        }

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
    
    //compares the time with the clock object given
     public boolean compareTime(Clock clock) {
        return (this.hour == clock.getHour() && this.minute == clock.getMinute());
    }
     //Sets tone from a list of media files given by the UI
     //Meaning the UI calls this method to set the tone
    public void setTone(Media file) {
        m = file;
    }
    //Returns the current tone set
    public Media getTone() {
        return m;
    }
    
    //Returns if the alarm is active or not
    public boolean getActive() {
        return active;
    }
    
    //Test alarm, plays the current tone that is set. Used primarily for the
    //Testing button in the UI. 
    
    public void testAlarm() {
        //If 
        if(!testPlaying) {
            player = new MediaPlayer(m);
            player.play(); 
        }
        testPlaying = true;
    }
    //returns the current media player. Everytime a new tone is set a new player is intialized.
    //This could be changed to setting just the tone. But this way is more concrete.
    public MediaPlayer getMediaPlayer() {
        return player;
    }
    //sets the volume of the player that plays the alarm tone
    public void setVolume(Double vol) {
        player.setVolume(vol);
    }
    //Returns true or false if the testPlayer (allows the user to test the alarm)
    //is currently playing
    public boolean getTestPlaying() {
        return testPlaying;
    }
    //sets play testing. All of the testPlayer methods and variables were added
    //Late in development. We need to change this and coding is never done.
    public void setTestPlaying(boolean test) {
        testPlaying = test;
    }
    //Start alarm starts playing the current set tone. It inits a new player
    //every time it does it to prevent other players from interferring. 
    public void startAlarm() {
        //System.out.println("Ring is Called");
        if(active) {
        //System.out.println("Wake up");
            player = new MediaPlayer(m);
            player.play(); 
        }
    }
    //stops the current player
    public void stopAlarm() {
        player.stop();
    }
     //Snooze alarm stops the current player and sets the alarm to 5 min in the future. 
    // It has some built in invalid handling because the other methods only deal with incrementing.
    // Should really put all this clock logic into one method, less likely to have bugs that way. 
    public void snoozeAlarm() {
        
        //Stop current tone
        stopAlarm();
        
        //Increment min
        minute += 5;
        //Invalid min/hour handling + clock logic
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
}
