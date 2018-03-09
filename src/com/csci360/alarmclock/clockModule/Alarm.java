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

    public void setAlarmTime(int hr, int min, String amPm) {
        hour = hr;
        minute = min;
        this.amPm = amPm;
    }

    public void activateAlarm(boolean active) {
        this.active = active;
    }
    public String getAlarmInfo() {
         String info = String.format("%d:%d %s",hour,minute,amPm);
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
        toneTest = "Wake up";
        return toneTest;
    }
}
