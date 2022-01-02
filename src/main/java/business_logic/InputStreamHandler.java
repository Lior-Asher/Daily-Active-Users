package business_logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Class to handle inputstream
public class InputStreamHandler {

    private List<UserEntry> _userEntries;
    private final File _in;

    public InputStreamHandler(File in) {
        _in = in;
        _userEntries = new ArrayList<>();
        readInputStream(_in);
    }

    public List<UserEntry> getAllEntries() {
        return _userEntries;
    }

    // Process a single file into a list of UserEntry.
    private void readInputStream(File in) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(in);

            // read the file
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                // accepted date formats
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][d/M/yyyy]");

                String headers;
                // check the stream is not null or is empty
                if ((headers = reader.readLine()) != null) {
                    if (headers.length() > 0) {
                        _userEntries = reader.lines().map(line -> line.split(",|\\s+"))
                                .map(entry -> new UserEntry(entry[0], LocalDate.parse(entry[1], dateFormatter), entry[2] ))
                                .collect(Collectors.toList());
                    }
                }
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: File not found. " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
