/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.radioModule;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Austin
 */
public class Station {
    //float freq;
    Double freq;
    String amFm;
    String mediaFile;
    Double volume;
    File file;
    Media m;
    MediaPlayer player;
    
    // Constructor for creating a station without frequency and am/fm
    public Station() {
        
    }
    
    // Status function for debugging purposes
    public MediaPlayer.Status Status() {
        return player.getStatus();
    }
    
    // Constructor for station to initialize frequency and am/fm
    public Station(double frequency, String amfm) {
        freq = frequency;
        amFm = amfm;
    }
    
    // Set frequency of station
    public void setStation(Double frequency) {
        freq = frequency;
    }
    
    // Set the station to AM or FM
    public void setAmFm(String amfm) {
        amFm = amfm;
    }
    
    // Set media file for the media player to specified file
    public void setMedia(String file) {
        mediaFile = file;
    }
    
    // Get frequency of station
    public double getFrequency() {
        return freq;
    }
    
    // Set volume of station's media player 
    public void setMediaVol(Double vol) {
        System.out.println("I am setting volume?");
        player.setVolume(vol);
        System.out.println("Why did it not set volume?");
    }
    
    // Stop the media player of station
    public void clearStation() {
        player.stop();
    }
    
    // Set station's media player to play the media file for the station
    public void setMediaPlayer() {
        file = new File(mediaFile);
        m = new Media(file.toURI().toString());
        player = new MediaPlayer(m);
    }
    
    // Get the station's media player
    public MediaPlayer getMediaPlayer() {
        return player;
    }
    
    // Play the station's media player
    public void playStation() {
        player.play();
    }
}
