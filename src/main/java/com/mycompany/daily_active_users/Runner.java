package com.mycompany.daily_active_users;

import business_logic.DAUOperations;
import business_logic.InputStreamHandler;
import business_logic.UserEntry;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import validators.Validation;

// Wrapper class to prevent interaction with the classes that do the work directly.
public class Runner {

    // Return DAUOperations count by providing filepath and a date to check and calling DAUOperations object to do the work.
    public static int getDAUCountAtDate(String filename, String date) throws Exception {

        String resourcesDir = "//resources//";
        String projDir = System.getProperty("user.dir");

        String fullPath = projDir + resourcesDir + filename;
        InputStreamHandler handler = new InputStreamHandler(new File(fullPath));
        List<UserEntry> entries = handler.getAllEntries();
        DAUOperations dauOps = new DAUOperations(entries);
        System.out.println(dauOps.toString()); //DEBUG

        if (Validation.isValidDate(date)) {

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][d/M/yyyy]");
            LocalDate localDate = LocalDate.parse(date, dateFormatter);

//        if (Validation.isValidDate(localDate)) {
            if (Validation.isValidFile(fullPath)) {
                return dauOps.getDAUCountAtDate(localDate);
            } else if (Validation.isDirectory(fullPath)) {
                throw new IOException("Must Specify File to Process!");
            } else {
                System.out.println("Invalid file path or invalid file: " + fullPath);
            }
        }
//        throw new Exception(MessageFormat.format("ERROR: Wrong date format for date {0}!", localDate));
        throw new Exception(MessageFormat.format("ERROR: Wrong date format for date {0}!", date));
    }
}
