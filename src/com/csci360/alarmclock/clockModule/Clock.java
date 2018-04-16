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
    private int minute;
    private int hour;
    private String amPm;
    private Alarm alarm1;
    private Alarm alarm2;
    Timer clock;


    public Clock() {
        minute = 0;
        hour = 12;
        amPm = "AM";
        alarm1 = new Alarm();
        alarm1.setAlarmTime(12, 0, "AM");
        alarm2 = new Alarm();
        alarm2.setAlarmTime(12, 0, "AM");
        clock = new Timer();
        
        
        clock.scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run()
           {
                minute++;
                checkClockLogic();
                checkAlarm();
            }
        }, 10000, 10000);
    }

    public void updateTime(int hour, int minute, String amPm) {
        this.hour = hour;
        this.minute = minute;
        this.amPm = amPm;

    }

    public String getTime() {
        String result;
        if(minute < 10)
            result = String.format("%d:0%d %s",hour,minute,amPm);
        else 
            result = String.format("%d:%d %s",hour,minute,amPm);
        //String result = String.format("%d:%d %s",hour,minute,amPm);
        return result;
    }

    public void setAlarm(int hour, int min, String amPm, int alarm) {
        if (alarm == 1) {
            alarm1.setAlarmTime(hour,min,amPm);
        }
        else if (alarm == 2) {
            alarm2.setAlarmTime(hour,min,amPm);
        }
    }

    public String checkAlarmInfo(int alarm) {
        if (alarm == 1) {
            return alarm1.getAlarmInfo();
        }
        else if (alarm == 2) {
            return alarm2.getAlarmInfo();
        }
        else {
            return "Incorrect alarm index";
        }
    }
    public void checkAlarm() {
        if(minute < 10){
            if(alarm1.getAlarmInfo().equals(String.format("%d:0%d %s",hour,minute,amPm))) {
                //System.out.println("Alarm1 goes off...");
                alarm1.startAlarm();
            }
            else if(alarm2.getAlarmInfo().equals(String.format("%d:0%d %s",hour,minute,amPm))) {
                //System.out.println("Alarm2 goes off...");
                alarm2.startAlarm();
            }
        }
        else{
            if(alarm1.getAlarmInfo().equals(String.format("%d:%d %s",hour,minute,amPm))) {
                //System.out.println("Alarm1 goes off...");
                alarm1.startAlarm();
            }
            else if(alarm2.getAlarmInfo().equals(String.format("%d:%d %s",hour,minute,amPm))) {
                //System.out.println("Alarm2 goes off...");
                alarm2.startAlarm();
            }
        }
    }
    
    public void snoozeAlarm(int alarm){
        if (alarm == 1){
            alarm1.snoozeAlarm();
        }
        else if(alarm == 2){
            alarm2.snoozeAlarm();
        }
    }

    public void activateAlarm(int alarm, boolean active){
        if (alarm == 1) {
            alarm1.activateAlarm(active);
        }
        else if (alarm == 2) {
            alarm2.activateAlarm(active);
        }
    }
    
    public void terminateClock() {
        clock.cancel();
    }
    
    public void setHour(int hr){
        if(hour == 13 ) {
           hour = 1;
        }
        if (hour == 12 && minute == 0 ) {
            if (amPm.equals("AM")){
            amPm = "PM";
            }
            else if (amPm.equals("PM")) {
            amPm = "AM";
            }
        }
        
        else if(hr == 0){
            if (amPm.equals("AM")){
                amPm = "PM";
            }
            else{
                amPm = "AM";
            }
            hr = 12;
        }
        hour = hr;
    }
    
    public void setMinute(int min){
        if (min == 60){
            min = 0;
        }
        else if(min < 0){
            min = 59;
        }
        minute = min;
    }
    
    public void alignTime(){
        if(hour > 12){
            hour %= 12;
            //switchAmPm(amPm);
        }
    }
    
    
    private void switchAmPm(){
        if(amPm.equals("AM")){
            amPm = "PM";
        }
        else if(amPm.equals("PM")){
            amPm = "AM";
        }
    }
    
    public Alarm getAlarm(int alarmNum){
        if(alarmNum == 1){
            return alarm1;
        }
        else if(alarmNum == 2){
            return alarm2;
        }
        return null;
    }
    
    public void checkClockLogic(){
        if (minute == 60) {
            minute = 0;
            hour++;
        }
        if(hour == 13 ) {
            hour = 1;
        }
        if (hour == 12 && minute == 0 ) {
            switchAmPm();
        }
    }
    
    public void incrementHour(){
        hour++;
        if(hour == 13){
            hour = 1;
        }
        if (hour == 12){
            switchAmPm();
        }
    }
    public void decrementHour(){
        hour--;
        if(hour == 0){
            hour = 11;
            switchAmPm();
        }
    }
    public void incrementMinute(){
        minute++;
        if(minute == 60)
            minute = 0;
    }
    public void decrementMinute(){
        minute--;
        if(minute < 0){
            minute = 59;
        }
    }
        
    
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
    
    
}
