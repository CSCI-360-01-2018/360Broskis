/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.util.Duration;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer; 


import com.csci360.alarmclock.clockModule.Alarm;
import com.csci360.alarmclock.clockModule.Clock;
import com.csci360.alarmclock.radioModule.Radio;
import com.csci360.alarmclock.radioModule.Station;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
//import com.csci360.alarmclock.clockModule.alarm;

/**
 * FXML Controller class
 *
 * @author Austin
 */
public class AlarmClockUIController implements Initializable {
    private Clock clk;// = new Clock();
    private Alarm testAlarm = new Alarm();
    //private Alarm alarm2 = new Alarm();
    private com.csci360.alarmclock.radioModule.Radio radio = new Radio();
    
    private Timer timer;
    
    private Text alarm1ActiveText;
    @FXML private TextField textF;
    @FXML private TextField clockField;
    @FXML private CheckBox alarm1ActCheck;
    @FXML private CheckBox alarm2ActCheck;
    @FXML private TextField alarm1SetTime;
    @FXML private TextField alarm2SetTime;
    @FXML private TextField alarm1Time;
    @FXML private TextField alarm2Time;
    
    @FXML private Button setAlarm1Button;
    @FXML private Button setAlarm2Button;
    //
    @FXML private TextField rVolText;
    @FXML private TextField rFreqText;
    @FXML private Slider rVolSlider;
    @FXML private Slider rFreqSlider;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   @FXML
    public void checkTime(ActionEvent e){
        clk = new Clock();
        timer = new Timer();
        clockField.setText(clk.getTime());
        System.out.println("Hi");
        
        timer.scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run()
           {
             clockField.setText(clk.getTime());   
           }
        }, 10000, 10000);
        
        
    }
    
    @FXML
    public void setHourUp(ActionEvent e){
        clk.setHour(clk.getHour()+1);
        clk.alignTime();
        clockField.setText(clk.getTime());
    }
    
    @FXML
    public void setHourDown(ActionEvent e){
        clk.setHour(clk.getHour()-1);
        clk.alignTime();
        clockField.setText(clk.getTime());
    }
    
    @FXML
    public void setMinuteUp(ActionEvent e){
        clk.setMinute(clk.getMinute()+1);
        clockField.setText(clk.getTime());
    }
    
    @FXML
    public void setMinuteDown(ActionEvent e){
        clk.setMinute(clk.getMinute()-1);
        clockField.setText(clk.getTime());
    }
    
    @FXML
    public void alarm1Active(ActionEvent e){
        //alarm1.activateAlarm(alarm1ActCheck.isSelected());
        //alarm1.activateAlarm(true);
        clk.activateAlarm(1,alarm1ActCheck.isSelected());
        System.out.println(clk.checkAlarmInfo(1));
    }
    
    @FXML
    public void alarm2Active(ActionEvent e){
        //alarm2.activateAlarm(alarm2ActCheck.isSelected());
        clk.activateAlarm(2,alarm2ActCheck.isSelected());
        //clk.
        System.out.println(clk.checkAlarmInfo(2));
    }
    
    
    @FXML
    public void setAlarm1Time(ActionEvent e){
        if(alarm1SetTime.getText() != null){
        // Set alarm 1 time
            String setTime = alarm1SetTime.getText();
            ParseAlarmTime alarmOneSettings = new ParseAlarmTime(setTime);
            int[] alarmTimes = alarmOneSettings.getAlarmTimes();
            String amPm = alarmOneSettings.getAlarmAmPm();
            clk.setAlarm(alarmTimes[0], alarmTimes[1], amPm, 1);
            clk.getAlarm(1).alignTime();
        
            alarm1Time.setText(clk.checkAlarmInfo(1));
        
        }
    }
    
   
    
    @FXML
    public void setAlarm2Time(ActionEvent e){
        
        String setTime = alarm2SetTime.getText();
        ParseAlarmTime alarmTwoSettings = new ParseAlarmTime(setTime);
        int[] alarmTimes = alarmTwoSettings.getAlarmTimes();
        String amPm = alarmTwoSettings.getAlarmAmPm();
        clk.setAlarm(alarmTimes[0], alarmTimes[1], amPm, 2);
        
        clk.getAlarm(2).alignTime();
        
        alarm2Time.setText(clk.checkAlarmInfo(2));
    }

    
    
    private void updateTime(){
        int min = clk.getMinute();
        int hr = clk.getHour();
    }
    
    @FXML
    public void setTextField(ActionEvent e){
        //clk.setAlarm(8, 10, "AM", 1);
        //alarm1.setAlarmTime(8, 10, "AM");
        textF.setText("Butts");
        //textF.setText(alarm1.getAlarmInfo().toString());
        
    }
    
    @FXML
    public void alarm1ActiveText(){
        testAlarm.ring();
    }
    
    @FXML
    public void setRadioVol(ActionEvent e){
        
        System.out.println("In radio vol set");
        radio.setVolume(Integer.parseInt(rVolText.getText()));
        System.out.println(radio.getVolume());
    }
    
    @FXML
    public void setRadioFreq(ActionEvent e){
        radio.setStation(new Station(Float.parseFloat(rFreqText.getText())));
        //radio.setStation(new Station(Integer.parseInt(rFreqText.getText())));
        System.out.println(radio.getStation());
    }
    
    
}

class ParseAlarmTime{
        int hour,min;
        String amPm;
        public ParseAlarmTime(String alarmStr){
            String[] splitStr = alarmStr.split(":");
            hour = Integer.parseInt(splitStr[0]);
            String rightHalfOfAlarmStr = splitStr[1];
            String[] minAmPm = rightHalfOfAlarmStr.split(" ");
            min = Integer.parseInt(minAmPm[0]);
            amPm = minAmPm[1];
            System.out.println(hour);
            System.out.println(min);
            System.out.println(amPm);
            
            
        }
 
        public int[] getAlarmTimes(){
            int[] alarmTime = {hour,min};
            return alarmTime;
        }
        public String getAlarmAmPm(){
            return amPm;
        }
    }
