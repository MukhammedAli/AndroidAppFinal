package com.example.finalproject;

import java.util.Date;

public class SaveDataProfile {
    public static String login;
    public static String name;
    public static Date date;

    public SaveDataProfile() {

    }
    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SaveDataProfile(String login, String name) {
        this.login = login;
        this.name = name;
    }
}
