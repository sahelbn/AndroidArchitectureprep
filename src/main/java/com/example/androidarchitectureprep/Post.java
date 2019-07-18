package com.example.androidarchitectureprep;

import com.google.gson.annotations.SerializedName;

class Post {

    private int id;
    private String title;
    private int userID;

  @SerializedName("body")
    private  String text;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getUserID() {
        return userID;
    }

    public String getText() {
        return text;
    }
}
