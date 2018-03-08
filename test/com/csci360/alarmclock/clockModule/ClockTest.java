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
        if (result.equals("8:24 AM")){
            System.out.println("Time updated");
            return;
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("Clock failed to update time correctly");
    }
    
    @Test 
    public void testSetAlarm1(){
        System.out.println("Set Alarm one to 8:11 PM");
        Clock instances = new Clock();
        instances.setAlarm(8,11,"AM",1);
        String result = instances.checkAlarmInfo(1);
        //System.out.println("result");
        assertEquals(result,"8:11 AM");
        //System.out.println("Alarm one set to 8:11");
    }
    @Test
    public void testSetAlarm2(){
        System.out.println("Set Alarm two to 8:12 PM");
        Clock instance = new Clock();
        instance.setAlarm(8,12,"AM",2);
        String result = instance.checkAlarmInfo(2);
        //System.out.println("result");
        assertEquals(result,"8:12 AM");
        //System.out.println("Alarm two set to 8:12");
    }

    @Test
    public void testClockFunction(){
        System.out.println("Starting Clock");
        Clock clock = new Clock();
        clock.setAlarm(8,20,"AM",2);
        clock.setAlarm(8,30,"AM",1);
        for(int i = 0; i < 10000; i++){
            
            System.out.println(clock.getTime());
            try{
            Thread.sleep(10);
            }
            catch(Exception e){
                
            }
        }
        fail("what?");
        
    }
    



 
    
}
