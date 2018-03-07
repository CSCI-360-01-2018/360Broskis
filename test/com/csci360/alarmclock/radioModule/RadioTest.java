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
     * Test of setActive method, of class Radio.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean Active = false;
        Radio instance = new Radio();
        instance.setActive(Active);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVolume method, of class Radio.
     */
    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        int volume = 0;
        Radio instance = new Radio();
        instance.setVolume(volume);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStation method, of class Radio.
     */
    @Test
    public void testSetStation() {
        System.out.println("setStation");
        Station station = null;
        Radio instance = new Radio();
        instance.setStation(station);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
