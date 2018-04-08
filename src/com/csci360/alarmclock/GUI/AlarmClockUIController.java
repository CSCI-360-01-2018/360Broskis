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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Austin
 */
public class AlarmClockUIController implements Initializable {
    private Text alarm1ActiveText;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void alarm1Active(){
        System.out.println("No");
        //textArea.setText("I love you Bowring");
        // SET ALARM 1 ACTIVE
    }
    
    @FXML
    public void alarm1ActiveText(){
        alarm1ActiveText.setText("Hello!");
    }
    
    
    
}
