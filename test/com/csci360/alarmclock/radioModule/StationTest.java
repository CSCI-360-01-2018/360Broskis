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
     * Test of setStation method, of class Station.
     */
    @Test
    public void testSetStation() {
        System.out.println("setStation");
        float frequency = 0.0F;
        float newStation = 99.1F;
        Station instance = new Station(frequency);
        instance.setStation(newStation);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getFrequency() == newStation){
            System.out.println("Set frequency of station");
            return;
        }
        fail("The test case is a prototype.");
    }

  
    /**
     * Test of getFrequency method, of class Station.
     */
    @Test
    public void testGetFrequency() {
        System.out.println("getFrequency");
        float expResult = 5.5F;
        Station instance = new Station(expResult);
        float result = instance.getFrequency();
        
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult == result){
            System.out.println("Retrieved frequency");
            return;
        }
        fail("The test case is a prototype.");
    }
    
}
