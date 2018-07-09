package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.SystemItem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kai on 7/8/2018.
 */
public class User {

    private String password;
    private String libNum;
    private String name;
    private String email;
    private String phone;


    public User(String libNum) {
        this.libNum = libNum;
        this.password = "password123";
    }

    public User(String libNum, String password) {
        this.libNum = libNum;
        this.password = password;

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

    public void setName(String name) {
        this.name = name;
    }

    public Boolean setEmail(String email) {
        Pattern p = Pattern.compile("(\\w*\\S)@(\\w*\\S)\\.(\\w*\\S)");
        Matcher m = p.matcher(email);
        if (m.matches()){
            this.email = email;
            return true;
        }
        else {
            System.out.println("Invaild format");
            return false;
        }

    }

    public Boolean setPhone(String phone) {
        Pattern p = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher m = p.matcher(phone);
        if (m.matches()){
            this.phone = phone;
            return true;
        }
        else {
            System.out.println("Invaild format");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLibNum() {
        return libNum;
    }

    public void printUserInfo(){
        System.out.println("Name: " + getName() + "(Library Number: " + getLibNum() + ")\n" + "Info:\n" +
                "\temail: " + getEmail() + "\n\tphone: " + getPhone());
    }
}
