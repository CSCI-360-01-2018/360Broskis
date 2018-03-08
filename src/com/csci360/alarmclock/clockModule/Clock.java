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
    private Alarm alarm1;
    private Alarm alarm2;

    
    public Clock() {
        alarm1 = new Alarm();
        alarm2 = new Alarm();
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
                
                //Alarm Checker
                
                if(alarm1.getAlarmInfo().equals(String.format("%d:%d %s",hour,minute,amPm))){
                    System.out.println("Alarm1 goes off...");
                }
                else if(alarm2.getAlarmInfo().equals(String.format("%d:%d %s",hour,minute,amPm))){
                    System.out.println("Alarm2 goes off...");
                }
                    
                    
                
            }
        }, 10, 10);
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

    public void setAlarm(int hour, int min, String amPm, int alarm){
        if (alarm == 1){
            alarm1.setAlarmTime(hour,min,amPm);
        }
        else if (alarm == 2){
            alarm2.setAlarmTime(hour,min,amPm);
        }
    }
    
    public String checkAlarmInfo(int alarm){
        if (alarm == 1){
            return alarm1.getAlarmInfo();
        }
        else if (alarm == 2){
            return alarm2.getAlarmInfo();
        }
        else{
            return "Incorrect alarm index";
        }
    }
    
    public void activateAlarm(int alarm, boolean active){
        if (alarm == 1){
            alarm1.activateAlarm(active);
        }
        else if (alarm == 2){
            alarm2.activateAlarm(active);
        }
    }
}

