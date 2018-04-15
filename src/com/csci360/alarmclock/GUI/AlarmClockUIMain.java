/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class AlarmClockUIMain extends Application {

private Stage primaryStage;

@Override
public void start(Stage primaryStage) {

mainWindow(primaryStage);  
primaryStage.setOnCloseRequest(e -> System.exit(0));
}

public void mainWindow(Stage primaryStage) {
    try {
        //AnchorPane load = (AnchorPane) FXMLLoader.load(AlarmClockUIMain.class.getResource("AlarmClockUI.fxml"));
        FXMLLoader loader =new FXMLLoader(AlarmClockUIMain.class.getResource("AlarmClockUI.fxml"));
        AnchorPane pane = loader.load();
        //MainWindowController mainWindowController = loader.getController();
        //mainWindowController.setMain(this);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    launch(args);
    }
}