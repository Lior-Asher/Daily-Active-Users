package com.mycompany.daily_active_users;

import business_logic.DAUOperations;
import business_logic.InputStreamHandler;
import business_logic.UserEntries;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, URISyntaxException {

//        if (args.length > 0) {
        String filename = "tinput.csv";//args[0];
        String filename2 = "input6.txt";
        String filename3 = "tinput_headers.csv";
        String date = "01/01/2020";//args[1];
        String date2 = "1/1/2020";
        String date3 = "2020/1/1";

        String resourcesDir = "//resources//";
        String projDir = System.getProperty("user.dir");

        // when reading specific file
        String fullPath = projDir + resourcesDir + filename2;
        InputStreamHandler handler = new InputStreamHandler(new File(fullPath));
        List<UserEntries> entries = handler.getAllEntries();
        DAUOperations ops = new DAUOperations(entries);
//        System.out.println(ops.toString());
        try {
            System.out.println(MessageFormat.format("Distinct users count for the {0}: {1}", date, ops.getDAUCount(date)));
            
//        System.out.println(entries.size());
//        entries.forEach(entry -> {
//            System.out.println(entry.toString());
//        });
//            try {
//                System.out.println(MessageFormat.format("There were {0} DAUs on the {1}", Runner.getDAUCount(new File(fullPath), date), date));
//
//            } catch (IOException e) {
//                System.out.println("Error IOException: " + e.getMessage());
//            } catch (Exception e) {
//                System.out.println("Error Exception: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Need arguments:\n1) file name\n2) date");
//        }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
