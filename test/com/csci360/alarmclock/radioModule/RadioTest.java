/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.radioModule;

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
public class RadioTest {
    
    public RadioTest() {
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
     * Test of setActive method and getActive method, of class Radio.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean Active = false;
        Radio instance = new Radio();
        instance.setActive(Active);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getActive() == false){
            System.out.println("Active switch to inactive");
            return;
        }
        fail("The test case is a prototype.");
    }
    
    
 

    /**
     * Test of setVolume method / getVolume method, of class Radio.
     */
    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        int volume = 0;
        Radio instance = new Radio();
        //It breaks here
        instance.setVolume(volume);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getVolume() == 0){
            System.out.println("Radio volume set to 0");
            return;
        }
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStation method, of class Radio.
     */
    
    @Test
    public void testSetStation() {
        System.out.println("setStation");
        Station station = new Station((float)103.5);
        Radio instance = new Radio();
        instance.setStation(station);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getStation() == 103.5){
            System.out.println("Station set to 103.5");
            return;
        }
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolume method, of class Radio.
     */
    
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        Radio instance = new Radio();
        int expResult = 0;
        int result = instance.getVolume();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult == result){
            System.out.println("Volumes are equal");
            return;
        }
        
        fail("The test case is a prototype.");
    }
    
    
}
