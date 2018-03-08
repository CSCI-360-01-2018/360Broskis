/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.clockModule;


import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author Austin
 */
public class Clock{
    private int minute = 0;
    private int hour = 12;
    private String amPm = "AM";

    
    public Clock() {
        Timer clock = new Timer();
        clock.scheduleAtFixedRate(new TimerTask() 
        {
           @Override
           public void run() 
           {
                minute++;
                if (minute == 60)
                {
                    minute = 0;
                    hour++;
                }
                if(hour == 13 ){
                    hour = 1;
                }
                if (hour == 12 && minute == 0 ){
                    if (amPm.equals("AM")){
                        amPm = "PM";
                    }
                    else if (amPm.equals("PM")){
                        amPm = "AM";
                    }
                }
                    
                    
                
            }
        }, 60000, 60000);
    }
     
    


    public void updateTime(int hour, int minute, String amPm) {
        this.hour = hour;
        this.minute = minute;
        this.amPm = amPm;
        
    }

    public String getTime() {
        String result = String.format("%d:%d %s",hour,minute,amPm);
        return result;
    }
    
    public int getHour(){
        return hour;
    }
    
    public int getMinute(){
        return minute;
    }

    public void tick() {
       
        
        }
    }

