package com.mycompany.daily_active_users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, URISyntaxException {

        if (args.length > 0) {
            String fileName = args[0];
            String date = args[1];

            String resourcesDir = "//resources//";
            String projDir = System.getProperty("user.dir");

            // when reading specific file
            String fullPath = projDir + resourcesDir + fileName;

            try {
                System.out.println(MessageFormat.format("There were {0} DAUs on the {1}", Runner.getDAUCount(new File(fullPath), date), date));

            } catch (IOException e) {
                System.out.println("Error IOException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error Exception: " + e.getMessage());
            }
        } else {
            System.out.println("Need arguments:\n1) file name\n2) date");
        }
    }
}
