/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validations;

import validators.Validation;
import static org.junit.Assert.*;

public class ValidationTest {

    public ValidationTest() {
    }

    /**
     * Test of isValidFile method, of class Validation.
     */
    @org.junit.Test
    public void testIsValidFile() {
        System.out.println("isValidFile");
        String fileName = "input.txt";
        String resourcesDir = "\\resources\\";
        String projDir = System.getProperty("user.dir");
        String fullPath = projDir + resourcesDir + fileName;
        boolean expResult = true;
        boolean result = Validation.isValidFile(fullPath);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidDate method, of class Validation.
     */
    @org.junit.Test
    public void testIsValidDateGood() {
        System.out.println("IsValidDateGood");
        String date = "01/01/2020";
        boolean expResult = true;
        boolean result = Validation.isValidDate(date);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsValidDateBad() {
        System.out.println("IsValidDateBad");
        String date = "01-01-2020";
        boolean expResult = false;
        boolean result = Validation.isValidDate(date);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testIsValidDateBad2() {
        System.out.println("IsValidDateBad2");
        String date = "01012020";
        boolean expResult = false;
        boolean result = Validation.isValidDate(date);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testIsValidDateBad3() {
        System.out.println("IsValidDateBad3");
        String date = "2020/01/01";
        boolean expResult = false;
        boolean result = Validation.isValidDate(date);
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
