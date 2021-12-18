package com.mycompany.daily_active_users;

import business_logic.DAU;
import java.io.File;
import java.io.IOException;
import validators.Validation;

// Wrapper class to prevent interaction with the classes that do the work directly.
public class Runner {

    // Return DAU count by providing filepath and a date to check and calling DAU object to do the work.
    public static int getDAUCount(File filePath, String date) throws Exception {
        
        if (Validation.isValidDate(date)) {
            
            DAU dau;
            if (Validation.isValidFile(filePath)) {
                
                dau = new DAU(filePath);

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
