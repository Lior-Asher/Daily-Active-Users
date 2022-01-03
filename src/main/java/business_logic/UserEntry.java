package business_logic;

import java.time.LocalDate;

public class UserEntry implements Comparable<UserEntry> {

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
    public int compareTo(UserEntry o) {
        if (this._userID.equals(o.getUserID()) && this._loginDate.toString().equals(o.getLoginDate().toString())) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "| User ID: " + _userID + " | Login Time: " + _loginDate + " " + _loginTime + " |";
    }
}
