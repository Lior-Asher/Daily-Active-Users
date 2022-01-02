/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daily_active_users;

import business_logic.DAUOperations;
import business_logic.InputStreamHandler;
import business_logic.UserEntry;
import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class RunnerTest {
    
    public RunnerTest() {
    }
    
    @Test
    public void testGetDAUCountAtDateGOOD() throws Exception {
        System.out.println("testGetDAUCountAtDateGOOD");
        String filename = "tinput_headers.csv";
        String date = "1/1/2020";

        int expResult = 3;
        int result = Runner.getDAUCountAtDate(filename, date);
        assertEquals(expResult, result);
        
    }
    
    public void testGetDAUCountAtDateBAD() throws Exception {
        System.out.println("testGetDAUCountAtDateBAD");
        String filename = "tinput_headers.csv";
        String date = "1/1/2020";

        int expResult = 2;
        int result = Runner.getDAUCountAtDate(filename, date);
        assertNotEquals(expResult, result);
        
    }
    
}
