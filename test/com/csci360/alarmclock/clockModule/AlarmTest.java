/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.clockModule;

import com.csci360.alarmclock.clockModule.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kossa
 */
public class AlarmTest {
    
    public AlarmTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTone method, of class Alarm.
     */
    @Test
    public void testSetTone() {
        System.out.println("setTone");
        Media file = null;
        Alarm instance = new Alarm();
        instance.setTone(file);
        if(file == instance.getTone()){
            System.out.println("Media tones are the same");
            return;
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ring method, of class Alarm.
     */
    /**
    @Test
    public void testRing() {
        System.out.println("ring");
        Alarm instance = new Alarm();
        String ringString;
        ringString = instance.ring();
        if(ringString.equals("Wake up")){
            System.out.println("Ring says: Wake up");
            return;
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of compareTime method, of class Alarm.
     */
    @Test
    public void testCompareTime() {
        System.out.println("compareTime");
        boolean equalTime = false;
        String ringString = "";
        Clock clock = new Clock();
        Alarm instance = new Alarm();
        clock.updateTime(8, 0, "am");
        instance.setAlarmTime(8, 1,"am");
        try {
            Thread.sleep(60000);
            if(instance.compareTime(clock)){
                equalTime = true;
            }
            if(equalTime){
                ringString = instance.ring();
            }
            if(ringString.equals("Wake up")){
                System.out.println("Alarm rung");
                return;
            }
            
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(AlarmTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //instance.compareTime(clock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testRings(){
        System.out.println("Test the ringer");
        Alarm instance = new Alarm();
        System.out.println("Hopefully the alarm will sound");
        instance.ring();
        System.out.println("method has been run for ring");
        
    }
    
   
}
