package com.palla.chatbox;

public class userProfile {
    public String username, userID;

    public userProfile(String username, String userID) {
        this.username = username;
        this.userID = userID;
    }

    public userProfile() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}