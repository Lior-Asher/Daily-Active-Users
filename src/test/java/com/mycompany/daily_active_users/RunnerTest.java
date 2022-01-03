/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daily_active_users;

import org.junit.Test;
import static org.junit.Assert.*;

public class RunnerTest {
    
    public RunnerTest() {
    }
    
    @Test
    public void testGetDAUCountAtDateCorrectRes() throws Exception {
        System.out.println("testGetDAUCountAtDateCorrectRes");
        String filename = "input.txt";
        String date = "01/01/2020";

        int expResult = 3;
        int result = Runner.getDAUCountAtDate(filename, date);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDAUCountAtDateCorrectRes2() throws Exception {
        System.out.println("testGetDAUCountAtDateCorrectRes2");
        String filename = "input.csv";
        String date = "1/1/2020";

        int expResult = 3;
        int result = Runner.getDAUCountAtDate(filename, date);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDAUCountAtDateWrongRes() throws Exception {
        System.out.println("testGetDAUCountAtDateWrongRes");
        String filename = "input.csv";
        String date = "01/01/2020";

        int expResult = 2;
        int result = Runner.getDAUCountAtDate(filename, date);
        assertNotEquals(expResult, result);
    }
    
    @Test(expected=Exception.class)
    public void testGetDAUCountAtDateWrongDateFormat() throws Exception {
        System.out.println("testGetDAUCountAtDateWrongDateFormat");
        String filename = "input.csv";
        String date = "01-01-2020";

        int expResult = 2;
        int result = Runner.getDAUCountAtDate(filename, date);
        assertNotEquals(expResult, result);
    }
    
    @Test(expected=Exception.class)
    public void testGetDAUCountAtDateWrongDateFormat2() throws Exception {
        System.out.println("testGetDAUCountAtDateWrongDateFormat2");
        String filename = "input.csv";
        String date = "2020/1/1";

        int expResult = 2;
        int result = Runner.getDAUCountAtDate(filename, date);
        assertNotEquals(expResult, result);
    }
}
