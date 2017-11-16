package edu.mnstate.mg0483fp.lollogin;

/**
 * Created by dongkyulim on 11/13/17.
 */

public class User {
    private String userName;
    private String password;

    public User() {
        this.userName = null;
        this.password = null;
    }
    public User(String username, String password){
        this.userName = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void toString(User user){
        String result = user.getUserName() + ", " + user.getPassword();
        System.out.println(result);
    }
}
