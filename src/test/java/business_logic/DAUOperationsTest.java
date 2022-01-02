/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ThisGuy
 */
public class DAUOperationsTest {
    
    public DAUOperationsTest() {
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
     * Test of getDAUCountAtDate method, of class DAUOperations.
     */
    @Test
    public void testGetDAUCountAtDate() throws Exception {
        System.out.println("getDAUCountAtDate");
        LocalDate localDate = null;
        DAUOperations instance = null;
        int expResult = 0;
        int result = instance.getDAUCountAtDate(localDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DAUOperations.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DAUOperations instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
