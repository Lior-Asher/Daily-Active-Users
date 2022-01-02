package business_logic;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DAUOperations {

    // Data structure to hold the data from the file. key - date, value - set of unique IDs.
    private final HashMap<LocalDate, HashSet<String>> _usersAtDate;
    private final List<UserEntry> _userEntries;

    public DAUOperations(List<UserEntry> userEntries) {
        _userEntries = userEntries;
        _usersAtDate = new HashMap<>();
        mapUserEntriesToDates();
    }

    private void mapUserEntriesToDates() {
        for (UserEntry _userEntry : _userEntries) {
            // if the date is already in the map add the id
            // else, create Map entry and add the id
            if (_usersAtDate.containsKey(_userEntry.getLoginDate())) {
                HashSet<String> ids = _usersAtDate.get(_userEntry.getLoginDate());
                ids.add(_userEntry.getUserID());
                _usersAtDate.put(_userEntry.getLoginDate(), ids);
            } else {
                HashSet<String> ids = new HashSet<>();
                ids.add(_userEntry.getUserID());
                _usersAtDate.put(_userEntry.getLoginDate(), ids);
            }
        }
    }

    // Return the number of unique users by date
    public int getDAUCountAtDate(LocalDate localDate) throws Exception {
        if (_usersAtDate.get(localDate) != null) {
            return _usersAtDate.get(localDate).size();
        }
        throw new Exception(MessageFormat.format("ERROR: No data for date {0}", localDate));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        _usersAtDate.entrySet().forEach(entry -> {
            str.append(entry.getKey());
            str.append(" ");
            str.append(entry.getValue());
            str.append("\n");

        });
        return str.toString();
    }
}
