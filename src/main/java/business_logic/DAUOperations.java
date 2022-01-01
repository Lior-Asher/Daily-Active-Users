package business_logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import validators.Validation;

public class DAUOperations {

    // Data structure to hold the data from the file. key - date, value - set of unique IDs.
    private final HashMap<LocalDate, HashSet<String>> _usersAtDate;
    private final List<UserEntries> _userEntries;

    public DAUOperations(List<UserEntries> userEntries) {
        _userEntries = userEntries;
        _usersAtDate = new HashMap<>();
        distinctUsersAtDate();
    }

    private void distinctUsersAtDate() {
        for (UserEntries _userEntry : _userEntries) {
            // if the date is already in the map
            // add the id
            if (_usersAtDate.containsKey(_userEntry.getLoginTime())) {
                HashSet<String> ids = _usersAtDate.get(_userEntry.getLoginTime());
                ids.add(_userEntry.getUserID());
                _usersAtDate.put(_userEntry.getLoginTime(), ids);
            } else {
                HashSet<String> ids = new HashSet<>();
                ids.add(_userEntry.getUserID());
                _usersAtDate.put(_userEntry.getLoginTime(), ids);
            }
        }
    }

    // Returns the number of daily unique users by date
    public int getDAUCount(String date) throws Exception {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][d/M/yyyy]");
        LocalDate localDate = LocalDate.parse(date, dateFormatter);

        if (Validation.isValidDate(localDate)) {
            if (_usersAtDate.get(localDate) != null) {
                return _usersAtDate.get(localDate).size();
            }
            throw new Exception("ERROR: The specifeid date was not found!");
        }

        throw new Exception("ERROR: Wrong date format!");
//        return 0;
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
