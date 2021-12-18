package business_logic;

import interfaces.ParseDataStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Strategy implementation for TXT files.
public class ParseTXT implements ParseDataStrategy {

    // TXT specific parsing method. Split line words on spaces.
    @Override
    public List<String[]> parseData(List<String> data) throws IOException {
        List<String[]> parsed = new ArrayList<>();

        data.stream()
                .map(x -> x.split("\\s+"))
                .forEach(x -> parsed.add(x));
        
        return parsed;
    }

}
