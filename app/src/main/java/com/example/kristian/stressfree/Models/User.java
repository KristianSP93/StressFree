package com.example.kristian.stressfree.Models;

import java.io.Serializable;


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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(String name, String email, String password) {
        Name = name;
        Email = email;
        Password = password;
    }

    public User(){

    }

    private String Name;
    private String Email;
    private String Password;
}
