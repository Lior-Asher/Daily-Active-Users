 package business_logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DAUOperations {

    // Data structure to hold the data from the file. key - date, value - set of unique IDs.
    private final HashMap<String, HashSet<String>> _usersAtDate;
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
            if(_usersAtDate.containsKey(_userEntry.getLoginTime())) {
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
    public int getDAUCount(String date) {  
        if(_usersAtDate.get(date) != null)
            return _usersAtDate.get(date).size();
        
        return 0;
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
