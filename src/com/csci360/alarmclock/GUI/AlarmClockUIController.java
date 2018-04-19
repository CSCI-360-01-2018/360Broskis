
package com.csci360.alarmclock.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.event.ActionEvent; 
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;  


import com.csci360.alarmclock.clockModule.Alarm;
import com.csci360.alarmclock.clockModule.Clock;
import com.csci360.alarmclock.radioModule.Radio;
import com.csci360.alarmclock.radioModule.Station;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;




//THe controller acts as the middle ware between the application logic and the UI

public class AlarmClockUIController implements Initializable,ChangeListener {
    
    //Clock / radio instances so that UI can grab text update variables
    private Clock clk;// = new Clock();
    private Radio radio;// = new Radio();
    private Timer timer;
   
    
    //All @FXML variables represent all buttons, textfriends, and other parts of
    //The UI that need to be connected to the application logic. 
    @FXML private TextField textF;
    @FXML private TextField  clockTextArea;
    @FXML private CheckBox alarm1ActCheck;
    @FXML private CheckBox alarm2ActCheck;
    @FXML private TextField alarm1SetTime;
    @FXML private TextField alarm2SetTime;
    @FXML private TextField alarm1Time;
    @FXML private TextField alarm2Time;
    @FXML private ChoiceBox alarmSetTone;
    @FXML private TextField rFreqText;
    @FXML private Slider rVolSlider;
     @FXML private Slider setVolAlarm;
    @FXML private CheckBox radioActiveCheck;
    @FXML private ChoiceBox radioStationChoice;
    
    private double prevStation;
    //Creates the drop down menus for the UI to select the different tones for 
    //alarms and radio stations
    private ObservableList<String> alarmToneList = FXCollections.observableArrayList();
    private ObservableList<String> radioStationList = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    
    //the initialize method sets up the application to be used by the UI
    //Its acts as the middleware.
    public void initialize(URL url, ResourceBundle rb) {
        
        //init radio instance
        radio = new Radio();
        
        //Add all alarm tones to alarms
        alarmToneList.add("alarmSound.mp3");
        alarmToneList.add("ghostdivision.mp3");
        alarmToneList.add("saygoodbye.mp3");
        alarmToneList.add("legionofmonsters.mp3");
        alarmToneList.add("messengerofgod.mp3");
        alarmToneList.add("metalgearphone.mp3");
        //inits the drop down array so user can select tone
        alarmSetTone.setItems(alarmToneList);
        //sets default alarm tone
        alarmSetTone.setValue("alarmSound.mp3");
        //sets all radio stations
        radioStationList.add("102.7");
        radioStationList.add("103.5");
        radioStationList.add("750");
        radioStationList.add("1030");
        //inits the radio station drop menu so user can select different radio
        radioStationChoice.setItems(radioStationList);
        
        //Whats hopefully a listener for change in volume
        rVolSlider.valueProperty().addListener(this);
        setVolAlarm.valueProperty().addListener(this);
        setVolAlarm.setValue(100);
        
         
         
        //Clock is initialized as well as timer to grab time at fixed rate.
        //The reason it is in the initalize method is so the clock starts automatically
        //preventing a while host of bugs where buttons are pressed before clock started.
        clk = new Clock();
        timer = new Timer();
        clockTextArea.setText(clk.getTime());
        System.out.println("Clocked Started");
        
        //At a interval set at the end of the method, the clock area is updated.
        //Its vital that the time is the same as the rate in the clock method!
        //Otherwise your update time isn't the same.
        timer.scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
             //Update Clock text
             clockTextArea.setText(clk.getTime());
           }
         //at this time (delay on first interval, delay on every interval)
        }, 1000, 1000);
        
    }
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            //System.out.println("listener worked");
            double radioVolume = rVolSlider.getValue();
            double newRadioVolume = radioVolume * .01;
            double alarmVolume = setVolAlarm.getValue();
            Double newAlarmVolume = alarmVolume * .01;
            //Integer radioVolumeAsInteger = newRadioVolume.intValue(); 
            //rVolText.setText( Integer.toString((int) newRadioVolume * 10));
            
            //System.out.println(newVolume);
            if(!rFreqText.getText().equals(""))
            radio.findStation( Double.parseDouble(rFreqText.getText()) ).getMediaPlayer().setVolume( newRadioVolume );
            if(alarm1ActCheck.isSelected())
            clk.getAlarm(1).setVolume(newAlarmVolume);
            if(alarm2ActCheck.isSelected())
            clk.getAlarm(2).setVolume(newAlarmVolume);
    }
    
    //Check Time allows the user to restart the clock if they wish.
    //It does this by doing the exact same thing as whats in the init method. But is activated by an
    //action event.
    
    //Better way of doing it, put the checkTime into its own method that is
    //Called by both the init method and the action event. 
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
    
    //These next 4 methods increment and decrement the clock by using the
    //Dedicated methods in clock. It calls the dedicated method in clock, then
    //updated the UI clock text area.
    
    //increment hour button, uses the clock method to do so
    //Then updates the clock text in the text area
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
    //Alarm1Active corresponds to the check box. If the checkbox it clicked
    ///It activates the clock instance's alarm 1. Then updates the alarm1s info
    //in the text field
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
     //Alarm2Active corresponds to the check box. If the checkbox it clicked
    ///It activates the clock instance's alarm 2. Then updates the alarm1s info
    //in the text field
    @FXML
    public void alarm2Active(ActionEvent e){
        //alarm2.activateAlarm(alarm2ActCheck.isSelected());
        clk.activateAlarm(2,alarm2ActCheck.isSelected());
        if(clk.getAlarm(2).getActive()) {
            clk.getAlarm(2).stopAlarm();
        }
    }
    
    //setAlarmTone sets the specified alarmTone to both alarm one and two.
    @FXML
    public void setAlarmTone(ActionEvent e) {
        //Grab the selected tone
        String tone = alarmSetTone.getValue().toString();
        //Find the file and generate path
        File file = new File(tone);
        Media m = new Media(file.toURI().toString());
        //Sets tone to alarm 1 and 2
        clk.getAlarm(1).setTone(m);
        clk.getAlarm(2).setTone(m);
        //If the testbutton was pressed to test the tone and is currenly playing.
        //stop the player.
        if(clk.getAlarm(1).getTestPlaying()) {
            clk.getAlarm(1).getMediaPlayer().stop();
            clk.getAlarm(1).setTestPlaying(false);
        }
        //Same thing for alarm 2
        if(clk.getAlarm(2).getTestPlaying()) {
            clk.getAlarm(2).getMediaPlayer().stop();
            clk.getAlarm(2).setTestPlaying(false);
        }
    }
    
    //Set alarm one time uses the parser class (below) to take in the string entered
    //and uses the values parsed to call the alarm method to set the alarm for alarm1. 
    @FXML
    public void setAlarm1Time(ActionEvent e){
        if(alarm1SetTime.getText() != null){
        // Set alarm 1 time
            //Upon set alarm button, get the text
            String setTime = alarm1SetTime.getText();
            //Creates an instance of the parse class. I wasn't able to return
            //multiple values of different types, so I used a class.
            //The constructor takes in the input when its created
            ParseAlarmTime alarmOneSettings = new ParseAlarmTime(setTime);
            //Using the methods in the class you can grab an integer a array that holds/
            //hour and min
            int[] alarmTimes = alarmOneSettings.getAlarmTimes();
            //As well as a string that holds the AM/PM
            String amPm = alarmOneSettings.getAlarmAmPm();
            //Set the alarm with the values given
            clk.setAlarm(alarmTimes[0], alarmTimes[1], amPm, 1);
            //Update text field
            alarm1Time.setText(clk.checkAlarmInfo(1));
        }
    }
    //Set Alarm 2, is an exact copy of setAlarm1Time. Refer to comments in that method.
    @FXML
    public void setAlarm2Time(ActionEvent e){
        
        String setTime = alarm2SetTime.getText();
        ParseAlarmTime alarmTwoSettings = new ParseAlarmTime(setTime);
        int[] alarmTimes = alarmTwoSettings.getAlarmTimes();
        String amPm = alarmTwoSettings.getAlarmAmPm();
        System.out.println(amPm);
        clk.setAlarm(alarmTimes[0], alarmTimes[1], amPm, 2);
        alarm2Time.setText(clk.checkAlarmInfo(2));
    }
   //alarmTest1, Allows the user to test the currently set tone.
    //There is a better way of doing this method as well. Without
    //Having to define new methods and boolean variables
    @FXML
    public void alarmTest1(){
        //Checks if the alarm1 testPlayer is playing
        if(clk.getAlarm(1).getTestPlaying()) {
            //If so stops it
            clk.getAlarm(1).getMediaPlayer().stop();
            //Sets the boolean varible to false
            clk.getAlarm(1).setTestPlaying(false);
        }
        //Starts playing the new tone
        clk.getAlarm(1).testAlarm();
    }
    //Exact copy for alarmTest1
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
    /**
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
    */
    
    @FXML
    public void testSlider(MouseEvent e){
        //System.out.println("Slider method called");
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
            //rVolText.setText( Integer.toString(ivol) );
            rVolSlider.setValue(ivol);
            
        }
    }
    //The snooze alarm methods can be called by both alarms
    //Calls the snooze alarm method in the clock method for the specified alarm
    //Then updates the alarm info after clock is incremented by 5
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
    
        
    //The ParseAlarmTime class is in charge of parsing the set alarm inputs
    //Its a solution to an annoying problem of note being able to return an array
    //of multiple values. So this was my solution.
class ParseAlarmTime {
    //Ints its own hour/min/amPm to parse into
    int hour,min;
    String amPm;
    
    
    //All of this is really overly-complicated error handling.
    //The parse itself is fairly simple.
    //It is able to handle most errors with a few exceptions like
    //Setting amPm to 3 characters when you have a 1-9 in the hour
    //Its not perfect but it gets the job done. If I had time to redo-it
    //Id have seperate text Fields for hour/min/amPm. SOO MUCH EASIER.
    public ParseAlarmTime(String alarmStr) {
        //System.out.println(alarmStr.length());
        //If the string is above 8 or below 7 ie 12:08 AM = 8 1:08 AM = 7
        if(alarmStr.length() > 8 || alarmStr.length() < 7){
            //prints to console its invalid and sets values to default alarm values.
            System.out.println("Invalid String Length");
            hour = 12;
            min = 0;
            amPm = "AM";
        }
        else{
        //The Parser!
        
        //Splits the string into two parts, with the : as the delimeter
        String[] splitStr = alarmStr.split(":");
        //uses the check for empty method to check is hour is empty
        if (checkForEmpty(splitStr[0])){
            System.out.println("Invalid Hour");
            hour = 12;
        }
        //sets hour equal to the left side of string turning it into a integer
        else{
            hour = Integer.parseInt(splitStr[0]);
        }
        
        //Sets rightHalfOfString to the right half of the string....
        String rightHalfOfAlarmStr = splitStr[1];
        //Splits the string using a space as delimeter
        String[] minAmPm = rightHalfOfAlarmStr.split(" ");
        //Checks if the left half of the right half of the input is empty (the minute)
        if (checkForEmpty(minAmPm[0])){
            System.out.println("Invalid Minute");
            min = 0;
        }
        else{
            min = Integer.parseInt(minAmPm[0]);
        }
        //checks if the right half of the right half of the input is empty (AM/PM)
        if (checkForEmpty(minAmPm[1])){
            System.out.println("Invalid AmPm");
            amPm = "AM";
        }
        else{
            amPm = minAmPm[1];
        }
      
        //System.out.println(hour);
        //System.out.println(min);
        //System.out.println(amPm);
        }
    }
    
    public boolean checkForEmpty(String string){
        //A secondary error handling method to prevent invalid inputs.
        //checks if the inputs for the different parts of the parsed string are not empty
        if (string.equals("") || string.equals(" ") || string.equals("  ")){
            return true;
        }
        else{
            return false;
        }
    }
    //Returns the alarms times in an int array. 
    public int[] getAlarmTimes(){
        int[] alarmTime = {hour,min};
        return alarmTime;
    }
    //returns amPm as a string.
    public String getAlarmAmPm(){
        return amPm;
    }
}

}
