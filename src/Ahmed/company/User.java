package Ahmed.company;
import java.util.Scanner;

public abstract class User {
    protected int userId;
    protected String userName;

    // user can search for drug by drug name
    public void searchDrug()
    {

    }
    public void displayDrugInfo()
    {

    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
