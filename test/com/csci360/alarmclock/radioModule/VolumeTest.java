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
public class VolumeTest {
    
    public VolumeTest() {
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
     * Test of setVolume method, of class Volume.
     */
    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        int vol = 0;
        Volume instance = new Volume();
        instance.setVolume(vol);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getVolume() == vol){
            System.out.println("Set volume to 0");
            return;
        }
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolume method, of class Volume.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        Volume instance = new Volume();
        int expResult = 0;
        int result = instance.getVolume();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult == result){
            System.out.println("Retrieved volume");
            return;
        }
        fail("The test case is a prototype.");
    }
    
}
