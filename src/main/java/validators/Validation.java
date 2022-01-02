package validators;

import java.io.File;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    
    public static boolean isValidFile(File file) {
        return (file.exists() && file.isFile() && (file.length() > 0));
    }
    
    // Check file exists.
    public static boolean isValidFile(String fullFilePath) {
        File file = new File(fullFilePath);
        return isValidFile(file);
    }
    
    public static boolean isDirectory(File file) {
        return (file.exists() && file.isDirectory() && (file.length() > 0));
    }
    
    public static boolean isDirectory(String filename) {
        File file = new File(filename);
        return isDirectory(file);
    }

    // Check the provided date is one of the accepted formats.
    public static boolean isValidDate(String date) {
        
        Pattern pattern1 = Pattern.compile("^\\d{1,2}/\\d{1,2}/\\d{4}$");
        Pattern pattern3 = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");
        Matcher match1 = pattern1.matcher(date);
        Matcher match3 = pattern3.matcher(date);
        
        return (match1.find() || match3.find());
    }
//    public static boolean isValidDate(LocalDate date) {
//        
//        Pattern pattern1 = Pattern.compile("^\\d{1,2}/\\d{1,2}/\\d{4}$");
//        Pattern pattern3 = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");
//        Matcher match1 = pattern1.matcher(date.toString());
//        Matcher match3 = pattern3.matcher(date.toString());
//        
//        return (match1.find() || match3.find());
//    }
}
