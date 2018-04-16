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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    @FXML private ChoiceBox alarmSetTone;
    //@FXML private ChoiceBox alarmSetTone1;
    @FXML private TextField rVolText;
    @FXML private TextField rFreqText;
    @FXML private Slider rVolSlider;
    @FXML private CheckBox radioActiveCheck;
    @FXML private ChoiceBox radioStationChoice;
    
    private double prevStation;
    
    private ObservableList<String> alarmToneList = FXCollections.observableArrayList();
    private ObservableList<String> radioStationList = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radio = new Radio();
        alarmToneList.add("alarmSound.mp3");
        alarmToneList.add("ghostdivision.mp3");
        alarmToneList.add("saygoodbye.mp3");
        alarmToneList.add("legionofmonsters.mp3");
        alarmToneList.add("messengerofgod.mp3");
        alarmSetTone.setItems(alarmToneList);       
        alarmSetTone.setValue("alarmSound.mp3");
        
        radioStationList.add("102.7");
        radioStationList.add("103.5");
        radioStationList.add("750");
        radioStationList.add("1030");
        radioStationChoice.setItems(radioStationList);
        
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
        }, 1000, 1000);
        
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
        }, 1000, 1000);
    }
    
    @FXML
    public void setHourUp(ActionEvent e){
        clk.incrementHour();
        clockTextArea.setText(clk.getTime());
    }
    
    @FXML
    public void setHourDown(ActionEvent e){
        clk.decrementHour();
        clockTextArea.setText(clk.getTime());
    }
    
    @FXML
    public void setMinuteUp(ActionEvent e){
       
        clk.incrementMinute();
        
        //clockField.setText(clk.getTime());
        clockTextArea.setText(clk.getTime());
    }
    
    @FXML
    public void setMinuteDown(ActionEvent e){
        //clk.setMinute(clk.getMinute()-1);
        clk.decrementMinute();
        //clockField.setText(clk.getTime());
        clockTextArea.setText(clk.getTime());
    }
    
    @FXML
    public void alarm1Active(ActionEvent e){
        //alarm1.activateAlarm(alarm1ActCheck.isSelected());
        //alarm1.activateAlarm(true);
        clk.activateAlarm(1,alarm1ActCheck.isSelected());
        if(clk.getAlarm(1).getActive()) {
            clk.getAlarm(1).stopAlarm();
        }
        System.out.println(clk.checkAlarmInfo(1));
    }
    
    @FXML
    public void alarm2Active(ActionEvent e){
        //alarm2.activateAlarm(alarm2ActCheck.isSelected());
        clk.activateAlarm(2,alarm2ActCheck.isSelected());
        if(clk.getAlarm(2).getActive()) {
            clk.getAlarm(2).stopAlarm();
        }
        //clk.
        //System.out.println(clk.checkAlarmInfo(2));
    }
    @FXML
    public void setAlarmTone(ActionEvent e) {
            //File file=new File("alarmSound.mp3");
    //Media m = new Media(file.toURI().toString());
            //
        //String tone = alarmSetTone.getText();
        String tone = alarmSetTone.getValue().toString();
        
        File file = new File(tone);
        Media m = new Media(file.toURI().toString());
        clk.getAlarm(1).setTone(m);
        clk.getAlarm(2).setTone(m);
        if(clk.getAlarm(1).getTestPlaying()) {
            clk.getAlarm(1).getMediaPlayer().stop();
            clk.getAlarm(1).setTestPlaying(false);
        }
        if(clk.getAlarm(2).getTestPlaying()) {
            clk.getAlarm(2).getMediaPlayer().stop();
            clk.getAlarm(2).setTestPlaying(false);
        }
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
            //clk.getAlarm(1).alignTime();
        
            alarm1Time.setText(clk.checkAlarmInfo(1));
        }
    }
    
    @FXML
    public void setAlarm2Time(ActionEvent e){
        
        String setTime = alarm2SetTime.getText();
        ParseAlarmTime alarmTwoSettings = new ParseAlarmTime(setTime);
        int[] alarmTimes = alarmTwoSettings.getAlarmTimes();
        String amPm = alarmTwoSettings.getAlarmAmPm();
        System.out.println(amPm);
        clk.setAlarm(alarmTimes[0], alarmTimes[1], amPm, 2);
        
        //clk.getAlarm(2).alignTime();
        
        alarm2Time.setText(clk.checkAlarmInfo(2));
    }

    private void updateTime(){
        int min = clk.getMinute();
        int hr = clk.getHour();
    }
    
    @FXML
    public void setTextField(ActionEvent e) {
        //clk.setAlarm(8, 10, "AM", 1);
        //alarm1.setAlarmTime(8, 10, "AM");
        textF.setText("Butts");
        //textF.setText(alarm1.getAlarmInfo().toString());
        
    }
    
    @FXML
    public void alarmTest1(){
        if(clk.getAlarm(1).getTestPlaying()) {
            clk.getAlarm(1).getMediaPlayer().stop();
            clk.getAlarm(1).setTestPlaying(false);
        }
        clk.getAlarm(1).testAlarm();
    }
    
    @FXML
    public void alarmTest2(){
        if(clk.getAlarm(2).getTestPlaying()) {
            clk.getAlarm(2).getMediaPlayer().stop();
            clk.getAlarm(2).setTestPlaying(false);
        }
        clk.getAlarm(2).testAlarm();
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
        Double vol = Double.parseDouble(rVolText.getText()) * .01;
        if(!rFreqText.getText().equals(""))
            radio.findStation( Double.parseDouble(rFreqText.getText()) ).getMediaPlayer().setVolume( vol );
        rVolSlider.setValue( Double.parseDouble(rVolText.getText()) );
        if(alarm1ActCheck.isSelected())
            clk.getAlarm(1).setVolume(vol);
        if(alarm2ActCheck.isSelected())
            clk.getAlarm(2).setVolume(vol);
        //radio.findStation( Double.parseDouble(rFreqText.getText()) ).setMediaVol( Double.parseDouble(rVolText.getText()));
    }
    
    @FXML
    public void setRadioFreq(ActionEvent e) {
        rFreqText.setText(radioStationChoice.getValue().toString());
        
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
            
            Double vol = radio.findStation(prevStation).getMediaPlayer().getVolume() * 100;
            int ivol = vol.intValue();
            System.out.println(ivol);
            rVolText.setText( Integer.toString(ivol) );
            rVolSlider.setValue(ivol);
            
        }
    }
    
    @FXML
    public void snoozeAlarm1(ActionEvent e){
        clk.snoozeAlarm(1);
        alarm1Time.setText(clk.checkAlarmInfo(1));
    }
    @FXML
    public void snoozeAlarm2(ActionEvent e){
        clk.snoozeAlarm(2);
        alarm2Time.setText(clk.checkAlarmInfo(2));
    }

class ParseAlarmTime {
    int hour,min;
    String amPm;
    public ParseAlarmTime(String alarmStr) {
        System.out.println(alarmStr.length());
        if(alarmStr.length() > 8 || alarmStr.length() < 7){
            System.out.println("Invalid String Length");
            hour = 12;
            min = 0;
            amPm = "AM";
        }
        else{
        String[] splitStr = alarmStr.split(":");
        if (checkForEmpty(splitStr[0])){
            System.out.println("Invalid Hour");
            hour = 12;
        }
        else{
            hour = Integer.parseInt(splitStr[0]);
        }
        //hour = Integer.parseInt(splitStr[0]);
        String rightHalfOfAlarmStr = splitStr[1];
        String[] minAmPm = rightHalfOfAlarmStr.split(" ");
        if (checkForEmpty(minAmPm[0])){
            System.out.println("Invalid Minute");
            min = 0;
        }
        else{
            min = Integer.parseInt(minAmPm[0]);
        }
        
        if (checkForEmpty(minAmPm[1])){
            System.out.println("Invalid AmPm");
            amPm = "AM";
        }
        else{
            amPm = minAmPm[1];
        }
        
        //min = Integer.parseInt(minAmPm[0]);
        //amPm = minAmPm[1];
        System.out.println(hour);
        System.out.println(min);
        System.out.println(amPm);
        }
    }
    
    public boolean checkForEmpty(String string){
        if (string.equals("") || string.equals(" ") || string.equals("  ")){
            return true;
        }
        else{
            return false;
        }
    }

    public int[] getAlarmTimes(){
        int[] alarmTime = {hour,min};
        return alarmTime;
    }
    public String getAlarmAmPm(){
        return amPm;
    }
}

}
