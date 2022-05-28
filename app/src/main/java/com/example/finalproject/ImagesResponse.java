package com.example.finalproject;

import java.io.Serializable;

public class ImagesResponse implements Serializable {

    private String birthday;
    private String char_id;
    private String name;
    private String[] occupation;
    private String img;
    private String status;



    public ImagesResponse(String char_id, String name, String birthday, String img, String status) {
        this.char_id = char_id;
        this.name = name;
        this.birthday = birthday;
        this.occupation = occupation;
        this.img = img;
        this.status = status;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getChar_id() {
        return char_id;
    }

    public void setChar_id(String char_id) {
        this.char_id = char_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getBirthday() {
//        return birthday;
//    }
//
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
//
    public String[] getOccupation() {
        return occupation;
    }

    public void setOccupation(String[] occupation) {
        this.occupation = occupation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

