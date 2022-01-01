/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daily_active_users;

import business_logic.DAUOperations;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAUTest {

    public DAUTest() {
    }

    /**
     * Test of getDAUCount method, of class DAUOperations.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetDAUCount() throws IOException {
        System.out.println("getDAUCount");
        String fileName = "input.txt";
        String resourcesDir = "\\resources\\";
        String projDir = System.getProperty("user.dir");
        String fullPath = projDir + resourcesDir + fileName;
        String date = "01/01/2020";
        File fin = new File(fullPath);
        DAUOperations instance = new DAUOperations(fin);
        int expResult = 3;
        int result = instance.getDAUCount(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of testGetDAUCountWHeaders method, of class DAUOperations.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetDAUCountWHeaders() throws IOException {
        System.out.println("testGetDAUCountWHeaders");
        String fileName = "input_headers.txt";
        String date = "1/1/2020";
        String resourcesDir = "\\resources\\";
        String projDir = System.getProperty("user.dir");
        String fullPath = projDir + resourcesDir + fileName;
        File fin = new File(fullPath);
        DAUOperations instance = new DAUOperations(fin);
        int expResult = 3;
        int result = instance.getDAUCount(date);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of testGetDAUCountWHeaders method, of class DAUOperations.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetDAUCountWHeadersCSV() throws IOException {
        System.out.println("testGetDAUCountWHeadersCSV");
        String fileName = "tinput_headers.csv";
        String date = "1/1/2020";
        String resourcesDir = "\\resources\\";
        String projDir = System.getProperty("user.dir");
        String fullPath = projDir + resourcesDir + fileName;
        File fin = new File(fullPath);
        DAUOperations instance = new DAUOperations(fin);
        int expResult = 3;
        int result = instance.getDAUCount(date);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAllItems method, of class DAUOperations.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetAllItems() throws IOException {
        System.out.println("getAllItems");
        String fileName = "input.txt";
        String resourcesDir = "\\resources\\";
        String projDir = System.getProperty("user.dir");
        String fullPath = projDir + resourcesDir + fileName;
        File fin = new File(fullPath);
        DAUOperations instance = new DAUOperations(fin);
        HashMap<LocalDate, HashSet<Integer>> expResult = new HashMap<>();
        // 01/01/2020
        HashSet<Integer> s = new HashSet<>(Arrays.asList(123));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "01/01/2020";
        LocalDate localDate = LocalDate.parse(date, dateFormatter);

        // 02/01/2020
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(789, 456));
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date2 = "02/01/2020";
        LocalDate localDate2 = LocalDate.parse(date2, dateFormatter2);

        // 03/02/2020
        HashSet<Integer> s3 = new HashSet<>(Arrays.asList(789, 456, 123));
        DateTimeFormatter dateFormatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date3 = "03/01/2020";
        LocalDate localDate3 = LocalDate.parse(date3, dateFormatter3);

        expResult.put(localDate3, s);
        expResult.put(localDate2, s2);
        expResult.put(localDate, s3);

        HashMap<LocalDate, HashSet<Integer>> result = instance.getAllItems();
        System.out.println(instance.toString());
        assertEquals(expResult, result);
    }
}
