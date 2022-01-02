package business_logic;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import validators.Validation;

public class DAUOperations {

    // Data structure to hold the data from the file. key - date, value - set of unique IDs.
    private final HashMap<LocalDate, HashSet<String>> _usersAtDate;
    private final List<UserEntry> _userEntries;

    public DAUOperations(List<UserEntry> userEntries) {
        _userEntries = userEntries;
        _usersAtDate = new HashMap<>();
        distinctUsersAtDate();
    }

    private void distinctUsersAtDate() {
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

    // Returns the number of daily unique users by date
    public int getDAUCountAtDate(String date) throws Exception {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][d/M/yyyy]");
        LocalDate localDate = LocalDate.parse(date, dateFormatter);

        if (Validation.isValidDate(localDate)) {
            if (_usersAtDate.get(localDate) != null) {
                return _usersAtDate.get(localDate).size();
            }
            throw new Exception(MessageFormat.format("ERROR: No date for {0}", localDate));
        }
        throw new Exception("ERROR: Wrong date format!");
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
