package interfaces;

import java.io.IOException;
import java.util.List;

// ParseData Strategy interface
public interface ParseDataStrategy {
    public List<String[]> parseData(List<String> data) throws IOException;
}
