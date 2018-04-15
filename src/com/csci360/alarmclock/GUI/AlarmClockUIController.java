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
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.util.Duration;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer; 


import com.csci360.alarmclock.clockModule.Alarm;
import com.csci360.alarmclock.clockModule.Clock;
import com.csci360.alarmclock.radioModule.Radio;
import com.csci360.alarmclock.radioModule.Station;
import java.io.File;
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
    private Radio radio;// = new Radio();
    
    private Timer timer;
    
    private Text alarm1ActiveText;
    @FXML private TextField textF;
    @FXML private TextField clockField;
    @FXML private TextArea  clockTextArea;
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
    @FXML private CheckBox radioActiveCheck;
    
    private double prevStation;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radio = new Radio();
    }    
   @FXML
    public void checkTime(ActionEvent e){
        clk = new Clock();
        timer = new Timer();
        //clockField.setText(clk.getTime());
        clockTextArea.setText(clk.getTime());
        System.out.println("Hi");
        
        timer.scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
             //clockField.setText(clk.getTime()); 
             clockTextArea.setText(clk.getTime());
           }
        }, 10000, 10000);
    }
    
    @FXML
    public void setHourUp(ActionEvent e){
        clk.setHour(clk.getHour()+1);
        clk.alignTime();
        //clockField.setText(clk.getTime());
        clockTextArea.setText(clk.getTime());
    }
    
    @FXML
    public void setHourDown(ActionEvent e){
        clk.setHour(clk.getHour()-1);
        clk.alignTime();
        //clockField.setText(clk.getTime());
        clockTextArea.setText(clk.getTime());
    }
    
    @FXML
    public void setMinuteUp(ActionEvent e){
       
        clk.setMinute(clk.getMinute()+1);
        
        //clockField.setText(clk.getTime());
        clockTextArea.setText(clk.getTime());
    }
    
    @FXML
    public void setMinuteDown(ActionEvent e){
        clk.setMinute(clk.getMinute()-1);
        //clockField.setText(clk.getTime());
        clockTextArea.setText(clk.getTime());
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
        //System.out.println(clk.checkAlarmInfo(2));
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
    public void alarmTest(){
        testAlarm.activateAlarm(true);
        testAlarm.ring();
    }
    
    @FXML
    public void setRadioActive(ActionEvent e) {
        radio.setActive(radioActiveCheck.isSelected());
        if(!radio.getActive()) {
            Station sta = new Station(0.0, "TEMP");
            double d = Double.parseDouble(rFreqText.getText());
            radio.findStation(d).clearStation();
        }
    }
   
    
    @FXML
    public void setRadioVol(ActionEvent e) {
        //Station sta = radio.findStation( Double.parseDouble(rFreqText.getText()) );
        //System.out.println("In radio vol set");
        
        radio.findStation( Double.parseDouble(rFreqText.getText()) ).getMediaPlayer().setVolume( Double.parseDouble(rVolText.getText()) * .01);
        //radio.findStation( Double.parseDouble(rFreqText.getText()) ).setMediaVol( Double.parseDouble(rVolText.getText()));
    }
    
    @FXML
    public void setRadioFreq(ActionEvent e) {
        if(radio.findStation(prevStation) != null) {
            radio.findStation(prevStation).getMediaPlayer().stop();
        }
        if(radio.getActive()) {
            //radio.setStation(new Station(Double.parseDouble(rFreqText.getText())), "");
            double d = Double.parseDouble((rFreqText.getText()));
            Station sta = new Station(d, "TEMP");
            if(d % 1 == 0)
                sta = new Station(d, "AM");
            else if(d % 1 != 0)
                sta = new Station(d, "FM");

            if(radio.findStation(d) != null) {
                    //radio.findStation(d).clearStation();
                radio.findStation(d).playStation();
                prevStation = d;
            }
        }
        //radio.g
        //radio.setStation(new Station(Integer.parseInt(rFreqText.getText())));
        //System.out.println(radio.getStation());
    }


class ParseAlarmTime {
    int hour,min;
    String amPm;
    public ParseAlarmTime(String alarmStr) {
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

class Sound {
    // temp. classes and functions to use Media and MediaLibrary imports
    
    String song = "";

    Media hit = new Media(new File(song).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(hit);
    // mediaPlayer.play();
}
}
