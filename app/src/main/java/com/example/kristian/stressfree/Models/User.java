package com.example.kristian.stressfree.Models;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public int getTheme() {
        return Theme;
    }

    public void setTheme(int theme) {
        Theme = theme;
    }

    public boolean isNotifications() {
        return Notifications;
    }

    public void setNotifications(boolean notifications) {
        Notifications = notifications;
    }

    public User(){

    }

    public User(String name, String email, String sex, String password, Date birthday, int theme, boolean notifications) {
        Name = name;
        Email = email;
        Sex = sex;
        Password = password;
        Birthday = birthday;
        Theme = theme;
        Notifications = notifications;
    }

    private String Name;
    private String Email;
    private String Sex;
    private String Password;
    private Date Birthday;
    private int Theme;
    private boolean Notifications;


}
