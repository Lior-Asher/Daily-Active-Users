package business_logic;

import java.time.LocalDate;

public class UserEntries {
    private final String _userID;
    private final LocalDate _loginTime;
    
    public UserEntries(String userID, LocalDate loginTime) {
        _userID = userID;
        _loginTime = loginTime;
    }
    
    public String getUserID() {
        return _userID;
    }
    
    public LocalDate getLoginTime() {
        return _loginTime;
    }
    
    @Override
    public String toString() {
        return "| User ID: " +  _userID + " | Login Time: " + _loginTime + " |";
    }
}
