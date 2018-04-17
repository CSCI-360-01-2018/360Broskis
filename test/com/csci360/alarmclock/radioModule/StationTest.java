/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.radioModule;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Austin
 */
public class StationTest {
    
    public StationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of clearStation method, of class Station.
     */
    @Test
    public void testClearStation() {
        //Default fail, need java FX to use media player
        System.out.println("clearStation");
        Station instance = new Station();
        instance.clearStation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testPlayStation() {
        //Default fail, need java FX to use media player
        System.out.println("playStation");
        Station instance = new Station();
        instance.setMedia("saygoodbye.mp3");
        instance.playStation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
}
