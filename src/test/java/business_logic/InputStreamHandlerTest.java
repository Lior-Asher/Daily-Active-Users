/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class InputStreamHandlerTest {

    public InputStreamHandlerTest() {
    }

    @Test
    public void testGetAllEntries() {
        System.out.println("getAllEntries");
        String filename = "input.csv";
        String resourcesDir = "//resources//";
        String projDir = System.getProperty("user.dir");
        String fullPath = projDir + resourcesDir + filename;
        
        InputStreamHandler instance = new InputStreamHandler(new File(fullPath));
        List<UserEntry> result = instance.getAllEntries();
        List<UserEntry> expResult = new ArrayList<>();
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][d/M/yyyy]");
        expResult.add(new UserEntry("123", LocalDate.parse("01/01/2020", dateFormatter), "08:45"));
        expResult.add(new UserEntry("456", LocalDate.parse("01/01/2020", dateFormatter), "09:00"));
        expResult.add(new UserEntry("123", LocalDate.parse("01/01/2020", dateFormatter), "10:56"));
        expResult.add(new UserEntry("789", LocalDate.parse("01/01/2020", dateFormatter), "11:57"));
        expResult.add(new UserEntry("123", LocalDate.parse("01/01/2020", dateFormatter), "15:45"));
        expResult.add(new UserEntry("456", LocalDate.parse("02/01/2020", dateFormatter), "16:32"));
        expResult.add(new UserEntry("789", LocalDate.parse("02/01/2020", dateFormatter), "16:32"));
        expResult.add(new UserEntry("123", LocalDate.parse("03/01/2020", dateFormatter), "15:45"));
        
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).compareTo(result.get(i)), 0);
        }
    }
}
