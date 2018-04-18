
package com.csci360.alarmclock.GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;



import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

//Main class of our UI.

// It loads the actual UI for the user to see.
public class AlarmClockUIMain extends Application {

private Stage primaryStage;

//The overrideen start method, sets the main window as the primary stage.
//Then when the window closes, it ends the program. This was a major bug that
//Found. 
@Override
public void start(Stage primaryStage) {

mainWindow(primaryStage);  
primaryStage.setOnCloseRequest(e -> System.exit(0));
}


//Loads are fxml file for the user to interact with.
public void mainWindow(Stage primaryStage) {
    try {
        FXMLLoader loader =new FXMLLoader(AlarmClockUIMain.class.getResource("AlarmClockUI.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    launch(args);
    }
}