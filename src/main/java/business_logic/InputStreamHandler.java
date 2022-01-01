package business_logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputStreamHandler {

    private List<UserEntries> _userEntries;
    private final File _in;

    public InputStreamHandler(File in) {
        _in = in;
        _userEntries = new ArrayList<>();
        readInputStream(_in);
    }

    public List<UserEntries> getEntries() {
        return _userEntries;
    }

    // Process a single file into a list of UserEntries.
    private void readInputStream(File in) {

        InputStream inputStream;
        try {
            inputStream = new FileInputStream(in);

            // read the file
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                /*
            stream.map(line -> line.split("\t"))
                    .map(a -> new MonitoredData(a[0], a[1], a[2]))
                    .collect(Collectors.toList());
                 */
                String headers;
                // check the stream is not null or is empty
                if ((headers = reader.readLine()) != null) {
                    if (headers.length() > 0) {
                        _userEntries = reader.lines().map(line -> line.split(",|\\s+"))
                                .map(entry -> new UserEntries(entry[0], entry[1]))
                                .collect(Collectors.toList());
                    }
                }

            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
