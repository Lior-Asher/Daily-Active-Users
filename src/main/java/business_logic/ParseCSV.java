package business_logic;

import interfaces.ParseDataStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Strategy implementation for CSV files.
public class ParseCSV implements ParseDataStrategy{

    // CSV specific parsing method. Split lines words on comma and space.
    @Override
    public List<String[]> parseData(List<String> data) throws IOException {
        List<String[]> parsed = new ArrayList<>();

        data.stream()
                .map(x -> x.split(",|\\s+"))
                .forEach(x -> parsed.add(x));
        
        return parsed;
    }
}
