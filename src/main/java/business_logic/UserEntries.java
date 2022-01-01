package business_logic;

public class UserEntries {
    private String _userID;
    private String _loginTime;
    
    public UserEntries(String userID, String loginTime) {
        _userID = userID;
        _loginTime = loginTime;
    }
    
    public String getUserID() {
        return _userID;
    }
    
    public String getLoginTime() {
        return _loginTime;
    }
    
    @Override
    public String toString() {
        return "| User ID: " +  _userID + " | Login Time: " + _loginTime + " |";
    }
}
