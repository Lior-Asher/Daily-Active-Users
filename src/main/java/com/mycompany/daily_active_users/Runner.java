package com.mycompany.daily_active_users;

import business_logic.DAUOperations;
import java.io.File;
import java.io.IOException;
import validators.Validation;

// Wrapper class to prevent interaction with the classes that do the work directly.
public class Runner {

    // Return DAUOperations count by providing filepath and a date to check and calling DAUOperations object to do the work.
    public static int getDAUCount(File filePath, String date) throws Exception {
        
        if (Validation.isValidDate(date)) {
            
            DAUOperations dau;
            if (Validation.isValidFile(filePath)) {
                
                dau = new DAUOperations(filePath);

                return dau.getDAUCount(date);
                
            } else if (Validation.isDirectory(filePath)) {
                throw new IOException("Must Specify File to Process!");
                
            } else {
                System.out.println("Invalid file path or invalid file: " + filePath);
            }
            
        } else {
            System.out.println("Invalid date");
        }
        
        return -1;
    }
}
