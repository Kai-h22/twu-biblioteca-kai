package com.twu.biblioteca;

/**
 * Created by Kai on 7/8/2018.
 */
public class User {

    private String password;
    private String libNum;

    public User(String libNum) {
        this.libNum = libNum;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean checkPassword(String password) {
        if (this.password.equals(password)){
            return true;
        }
        return false;

    }
}
