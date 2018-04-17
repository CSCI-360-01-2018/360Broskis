
package com.csci360.alarmclock.clockModule;
import java.util.Timer;
import java.util.TimerTask;



//The Clock class is what holds creates our timer we use to mimic the clock. It also holds two instances
//our alarm class in order to simulate our clock having two seperate alarms. It also acts as our main interface with the controller.
public class Clock{
    private int minute;
    private int hour;
    private String amPm;
    private Alarm alarm1;
    private Alarm alarm2;
    Timer clock;

    //Our constructor for clock class. It sets the time and alarms to default values to avoid errors.
    public Clock() {
        minute = 0;
        hour = 12;
        amPm = "AM";
        alarm1 = new Alarm();
        alarm1.setAlarmTime(12, 0, "AM");
        alarm2 = new Alarm();
        alarm2.setAlarmTime(12, 0, "AM");
        clock = new Timer();
        
        //Our clock works by incrementing minute at a fixed rate. 
        //It calls out "checkClockLogic();" to deal with the clock logic.
        //ie incrementing hour  when minute hits 60.
        //It also checks for the alarm everytime the minute is incremented
        clock.scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run()
           {
                minute++;
                checkClockLogic();
                checkAlarm();
            }
           //where we set the rate, for demonstration purposes its at every 10s
        }, 1000, 1000);
    }
    //This is how we update our time. This is more for testing purposes, as our UI
    //Only allows for incrementing values.
    public void updateTime(int hour, int minute, String amPm) {
        this.hour = hour;
        this.minute = minute;
        this.amPm = amPm;

    }
    //Returns a string formatted as 12:00 AM with the current values. Its what we use to 
    //display on the main screen.
    public String getTime() {
        String result;
        if(minute < 10)
            result = String.format("%d:0%d %s",hour,minute,amPm);
        else 
            result = String.format("%d:%d %s",hour,minute,amPm);
        //String result = String.format("%d:%d %s",hour,minute,amPm);
        return result;
    }
    
    //Clock has two Alarm Class objects. This methods allows us to set the alarm
    //times and specify which alarm to set.
    public void setAlarm(int hour, int min, String amPm, int alarm) {
        if (alarm == 1) {
            alarm1.setAlarmTime(hour,min,amPm);
        }
        else if (alarm == 2) {
            alarm2.setAlarmTime(hour,min,amPm);
        }
    }
    //For the specificed alarm returns the hour,min,am or pm values. 
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
    
    /**
     * This method is called in our main timer every time the minute is incremented.
     * it checks if the alarm info matches the time info. 
     * 
     * The inner if else statements allows us to differentiate the two alarms
     * The outer if/else statement deals with a formatting issue we ran into with a numbers less than 10.
     * Ie 12:01 can't be tested for equality with just "%d:%d %s",hour,minute,amPm
     */
    public void checkAlarm() {
        //Check for equality between alarm and time less than 10
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
        //Check for equality between alarm and time greater than 10
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
    //The this method calls "snoozeAlarm()" for either alarm instance.
    public void snoozeAlarm(int alarm){
        if (alarm == 1){
            alarm1.snoozeAlarm();
        }
        else if(alarm == 2){
            alarm2.snoozeAlarm();
        }
    }
    //Activates the alarm for either instance using the "activateAlarm(int alarm)" method in the Alarm Class
    public void activateAlarm(int alarm, boolean active){
        if (alarm == 1) {
            alarm1.activateAlarm(active);
        }
        else if (alarm == 2) {
            alarm2.activateAlarm(active);
        }
    }
    //Terminates the clock thread
    public void terminateClock() {
        clock.cancel();
    }
    //Switches am for pm and vice versa
    private void switchAmPm(){
        if(amPm.equals("AM")){
            amPm = "PM";
        }
        else if(amPm.equals("PM")){
            amPm = "AM";
        }
    }
    //Returns the alarm object in order for the controller to call the Alarm's methods
    public Alarm getAlarm(int alarmNum){
        if(alarmNum == 1){
            return alarm1;
        }
        else if(alarmNum == 2){
            return alarm2;
        }
        return null;
    }
    //Clock logic, as minute increments in the timer this sets min/hour to the appropiate values
    //Originally this was in the timer itself, but it really desearves its own function
    
    public void checkClockLogic(){
        
        //if min reaches 60, reset to 0. Simulating a minute
        if (minute == 60) {
            minute = 0;
            hour++;
        }
        //Once hour reaches 13, it is reset to 1. To simulate a clock going from 12:59 to 1:00
        if(hour == 13 ) {
            hour = 1;
        }
        //As the clock increments, once it reaches 12:00 it switches the AM/PM
        //Simulating the time switch from 11:59 AM to 12:00 PM
        if (hour == 12 && minute == 0 ) {
            switchAmPm();
        }
    }
    
    //There was some depricated methods for set hour. But to overcome some edge cases
    //we gave each of the buttons in the UI their own methods. To prevent logic issues.
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
        if (hour == 12){
            switchAmPm();
        }
        hour--;
        if(hour == 0){
            hour = 12;
            //switchAmPm();
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
    
    //Returns Hour for testing purposes
    public int getHour() {
        return hour;
    }
    //Returns Min for testing purposes
    public int getMinute() {
        return minute;
    }
}
