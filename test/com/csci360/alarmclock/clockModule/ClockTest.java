/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock.clockModule;

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
public class ClockTest {
    
    public ClockTest() {
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
     * Test of updateTime method, of class Clock.
     */
    @Test
    public void testUpdateTime() {
        System.out.println("updateTime");
        Clock instance = new Clock();
        int hour = 8;
        int minute = 10;
        String amPm = "AM";
        instance.updateTime(hour, minute, amPm);
        
        String result = instance.getTime();
        if (result.equals("8:10 AM")){
            System.out.println("Time updated");
            return;
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("Clock failed to update time correctly");
    }
    /**
    @Test
    public void testClockFunction(){
        System.out.println("Starting Clock");
        Clock clock = new Clock();
        for(int i = 0; i < 10; i++){
            
            System.out.println(clock.getTime());
            try{
            Thread.sleep(60000);
            }
            catch(Exception e){
                
            }
        }
        fail("what?");
        
    }
*/


 
    
}
