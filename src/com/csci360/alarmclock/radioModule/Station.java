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
    File file;//=new File(mediaFile);
    Media m;// = new Media(file.toURI().toString());
    MediaPlayer player;// = new MediaPlayer(m);
    public Station(){
        
    }
    
    public Station(double frequency, String amfm) {
        // is this function necessary w/ setStation?
        freq = frequency;
        amFm = amfm;
    }
    
    public void setStation(Double frequency) {
        freq = frequency;
    }
    
    public void setAmFm(String amfm){
        amFm = amfm;
    }
    
    public void setMedia(String file){
        mediaFile = file;
    }
    
    public double getFrequency() {
        return freq;
        //return 0;
    }
    
    public void setVolume(Double vol) {
        volume = vol;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public void setMediaVol(Double vol) {
        System.out.println("I am setting volume?");
        player.setVolume(vol);
        System.out.println("Why did it not set volume?");
    }
    
    public void clearStation() {
        player.stop();
    }
    
    public void setMediaPlayer() {
        file = new File(mediaFile);
        m = new Media(file.toURI().toString());
        player = new MediaPlayer(m);
    }
    
    public MediaPlayer getMediaPlayer() {
        return player;
    }
    
    public void playStation(){
        //file=new File(mediaFile);
        //m = new Media(file.toURI().toString());
        
        //player = new MediaPlayer(m);
        //player.setVolume(volume);
        player.play();
    }
}
