package validators;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    
    public static boolean isValidFile(File file) {
        return (file.exists() && file.isFile() && (file.length() > 0));
    }
    
    public static boolean isDirectory(File file) {
        return (file.exists() && file.isDirectory() && (file.length() > 0));
    }
    
    // Check file exists.
    public static boolean isValidFile(String fullFilePath) {
        File file = new File(fullFilePath);
        return isValidFile(file);
    }

    // Check the provided date is one of the accepted formats.
    public static boolean isValidDate(String date) {
        
        // accepted date format examples: 02/01/2020 or 2/1/2020
        Pattern pattern1 = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
        Pattern pattern2 = Pattern.compile("^\\d{1}/\\d{1}/\\d{4}$");
        Matcher match1 = pattern1.matcher(date);
        Matcher match2 = pattern2.matcher(date);
        
        return (match1.find() || match2.find());
    }
}
