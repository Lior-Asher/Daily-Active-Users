package business_logic;

import interfaces.ParseDataStrategy;
import java.io.IOException;
import java.util.List;

// Main class to select the right data processing strategy.
public class StreamReaderDataContext {
    private final ParseDataStrategy _strategy;    
    
    public StreamReaderDataContext(ParseDataStrategy strategy) {
        _strategy = strategy;
    }
    
    // The parsing method is based on file type.
    public List<String[]> parseDataStrategy(List<String> data) throws IOException {
        return _strategy.parseData(data);
    }
}
