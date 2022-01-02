 package com.mycompany.daily_active_users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, URISyntaxException {

//        if (args.length > 0) {
        String filename = "tinput.csv";//args[0];
        String filename2 = "input6.txt";
        String filename3 = "tinput_headers.csv";
        String date = "01/01/2020";//args[1];
        String date2 = "1/1/2020";
        String date3 = "2020/1/1";
        String date4 = "1/2/2020";
        String date5 = "01-01-2020";
        
        int distinctUsersCount;
        try {
            distinctUsersCount = Runner.getDAUCountAtDate(filename3, date2);
            System.out.println(MessageFormat.format("Distinct users count for the {0}: {1}", date2, distinctUsersCount));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
