/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.clockModule;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Austin
 */

public class Clock {
    private int minute;
    private int hour;
    private String amPm;
    private Calendar cal;
    private Date date;
    
    
    // Create timer + timer task (clock cycle)
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            minute++;
            System.out.println("Minutes passed: " + minute);
            // timer.scheduleAtFixedRate(task, 60000, 60000) ---- where does this go?
          }
    };
    
    public Clock() {
        // random comment for git test
        cal = new GregorianCalendar();
    }

    public void updateTime(int hour, int minute, String amPm) {
        // Set time
        //Calendar.set(Calendar.HOUR_OF_DAY, int hours).
        amPm = amPm.toLowerCase();
        this.amPm = amPm;
        cal.set(Calendar.HOUR, hour);
        cal.set(Calendar.MINUTE, minute);

        if(amPm.equals("am"))
            cal.set(Calendar.AM_PM, Calendar.AM);
        else
            cal.set(Calendar.AM_PM, Calendar.PM);
        
        // This will set time to HH:MM:SS with input Hour / Minute 
        System.out.println(cal.getTime() + " " + amPm.toUpperCase());
    }

    public int getTime() {
        String theTime;
        theTime = String.format("The current time is: %d:%d", hour, minute);
        System.out.println(theTime + amPm);
        System.out.println(cal.getTime());
        // something like this ^^
        return 0;
    }

    public void tick() {
        // Tick clock
        timer.scheduleAtFixedRate(task, 60000, 60000);
        

        if (hour == 24 && minute == 60) {
          // reset timer here, every 24hrs
          timer.cancel(); // stops thread
          timer.scheduleAtFixedRate(task, 60000, 60000);
        }
    }

    public static void main(String[] args) {
        Clock clk = new Clock();
    }
}
