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

import com.csci360.alarmclock.clockModule.Alarm;
import com.csci360.alarmclock.clockModule.Clock;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.CheckBox;
//import com.csci360.alarmclock.clockModule.alarm;

/**
 * FXML Controller class
 *
 * @author Austin
 */
public class AlarmClockUIController implements Initializable {
    private Clock clk;// = new Clock();
    private Alarm alarm1 = new Alarm();
    private Alarm alarm2 = new Alarm();
    
    private Timer timer;
    
    private Text alarm1ActiveText;
    @FXML private TextField textF;
    @FXML private TextField clockField;
    @FXML private CheckBox alarm1ActCheck;
    @FXML private CheckBox alarm2ActCheck;
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
        clockField.setText(clk.getTime());
    }
    
    @FXML
    public void setHourDown(ActionEvent e){
        clk.setHour(clk.getHour()-1);
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
        alarm1ActiveText.setText("Hello!");
    }
    
   
    
    
}
