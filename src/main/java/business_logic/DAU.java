package business_logic;

import interfaces.ParseDataStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.maven.surefire.shared.lang3.math.NumberUtils;

public class DAU {

    // Data structure to hold the data from the file. key - date, value - set of unique IDs.
    private HashMap<LocalDate, HashSet<Integer>> _usersAtDate;
    private final File _in;

    // Used when a single file is provided.
    public DAU(File fin) throws IOException {
        _in = fin;
        readInputStream(_in);
    }

    // Parse input list.
    // Each string array in the list is split into [ id, date, time ]
    private void parseInput(List<String> data, ParseDataStrategy strategy) throws IOException {

        List<String[]> parsedData;

        ParseDataContext context = new ParseDataContext(strategy);
        parsedData = context.parseDataStrategy(data);

        if (parsedData.isEmpty()) {
            throw new IOException("is empty!");
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][d/M/yyyy]");

        LocalDate date;
        LocalDate tmp;
        HashSet<Integer> _IDs = new HashSet<>();
        _usersAtDate = new HashMap<>();

        int i = 0;
        // check if the first line is header
        // if not, start reading the file from the second row.
        if(!NumberUtils.isParsable(parsedData.get(i)[0]))
            i = 1;
        
        for (; i < parsedData.size() - 1; i++) {

            // Compare current date to the next date.
            // As long as the dates are equal - ad ids to the current date set of users.
            // When the dates are different, add new map entry - new date new map key
            date = LocalDate.parse(parsedData.get(i)[1], dateFormatter);
            tmp = LocalDate.parse(parsedData.get(i + 1)[1], dateFormatter);

            if (date.compareTo(tmp) == 0) {
                _IDs.add(Integer.parseInt(parsedData.get(i)[0]));

            } else {
                _IDs.add(Integer.parseInt(parsedData.get(i)[0]));

                _usersAtDate.put(date, _IDs); // close map's date entry
                _IDs = new HashSet<>(); // create new set for next date
            }
        }

        // Last 2 elements in the file
        date = LocalDate.parse(parsedData.get(parsedData.size() - 1)[1], dateFormatter);
        tmp = LocalDate.parse(parsedData.get(parsedData.size() - 2)[1], dateFormatter);

        if (date.compareTo(tmp) == 0) {
            _IDs.add(Integer.parseInt(parsedData.get(parsedData.size() - 1)[0]));
            _IDs.add(Integer.parseInt(parsedData.get(parsedData.size() - 2)[0]));
            _usersAtDate.put(date, _IDs); // close map's date entry
        } else {
            _IDs.add(Integer.parseInt(parsedData.get(parsedData.size() - 1)[0]));
            _usersAtDate.put(date, _IDs); // close map's date entry
        }
    }

    // Process a single file into a list of strings, based on file extension.
    private void readInputStream(File in) throws IOException {

        InputStream inputStream = new FileInputStream(in);
        String fileName = in.getName();
        String[] fileParts = fileName.split("\\."); // split file to get it's extension
        String fileExtension = fileParts[1];

        List<String> lines = new ArrayList<>();

        // read the file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            // make sure the file is not empty
            while ((line = reader.readLine()) != null) {
                if (line.length() > 0) {
                    lines.add(line);
                }
            }
        }
        switch (fileExtension.toLowerCase()) {
            case "txt" -> {
                try {
                    parseInput(lines, new ParseTXT());

                } catch (IOException ex) {
                    System.out.println(MessageFormat.format("ERROR: {0} {1}", in.getName(), ex.getMessage()));
                }
            }
            case "csv" -> {
                try {
                    parseInput(lines, new ParseCSV());

                } catch (IOException ex) {
                    System.out.println(MessageFormat.format("ERROR: {0} {1}", in.getName(), ex.getMessage()));
                }
            }
            default ->
                System.out.println("Unsupported file extension!");
        }
    }

    // Returns the number of daily unique users by date
    public int getDAUCount(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][d/M/yyyy]");
        LocalDate localDate = LocalDate.parse(date, dateFormatter);

        // check if the date is mapped.
        if (!_usersAtDate.containsKey(localDate)) {
            return 0;
        }

        HashSet<Integer> ids = _usersAtDate.get(localDate);
        return ids.size();
    }
    
    // Return all items
    public HashMap<LocalDate, HashSet<Integer>> getAllItems() {
        if (_usersAtDate.isEmpty()) {
            return new HashMap<>();
        }

        return _usersAtDate;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        _usersAtDate.entrySet().forEach(entry -> {
            str.append(entry.getKey() + " " + entry.getValue() + "\n");
        });

        return str.toString();
    }
}
