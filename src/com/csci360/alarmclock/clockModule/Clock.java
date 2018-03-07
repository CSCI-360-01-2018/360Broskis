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

public class Clock {
    public Clock() {
        // random comment for git test
    }

    public void updateTime(int hour, int minute, String amPm) {
        // Set time
    }

    public int getTime() {
        String theTime = System.out.println("The current time is: %d:%d", hour, minute);
        // something like this ^^
        return 0;
    }

    public void tick() {
        // Tick clock
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
          public void run() {
            minute++;
            System.out.println("Minutes passed: " + minute);
            // timer.scheduleAtFixedRate(task, 60000, 60000) ---- where does this go?
          }
        };

        if (hour == 24 && minute == 60) {
          // reset timer here, every 24hrs
          timer.cancel(); // stops thread
        }
    }

    public static void main(String[] args) {
        Clock clk = new Clock();
    }
}
