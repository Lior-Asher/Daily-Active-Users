 package com.mycompany.daily_active_users;

import business_logic.DAUOperations;
import business_logic.InputStreamHandler;
import business_logic.UserEntry;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.List;

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
        String fullPath = projDir + resourcesDir + filename3;
        InputStreamHandler handler = new InputStreamHandler(new File(fullPath));
        List<UserEntry> entries = handler.getAllEntries();
        DAUOperations ops = new DAUOperations(entries);
        System.out.println(ops.toString());
        try {
            System.out.println(MessageFormat.format("Distinct users count for the {0}: {1}", date2, ops.getDAUCountAtDate(date2)));
            
//        System.out.println(entries.size());
//        entries.forEach(entry -> {
//            System.out.println(entry.toString());
//        });

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
