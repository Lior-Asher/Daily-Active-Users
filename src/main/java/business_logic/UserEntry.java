package business_logic;

import java.time.LocalDate;

public class UserEntry {
    private final String _userID;
    private final LocalDate _loginDate;
    private final String _loginTime;
    
    public UserEntry(String userID, LocalDate loginDate, String loginTime) {
        _userID = userID;
        _loginDate = loginDate;
        _loginTime = loginTime;
    }
    
    public String getUserID() {
        return _userID;
    }
    
    public LocalDate getLoginDate() {
        return _loginDate;
    }
    
    public String getLoginTime() {
        return _loginTime;
    }
    
    @Override
    public String toString() {
        return "| User ID: " +  _userID + " | Login Time: " + _loginDate + " " + _loginTime + " |";
    }
}
