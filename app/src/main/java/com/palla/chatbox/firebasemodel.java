package com.palla.chatbox;

public class firebasemodel {
    String name;
    String uid;
    String image;
    String status;

    public firebasemodel() {
    }

    public firebasemodel(String name, String uid, String image, String status) {
        this.name = name;
        this.uid = uid;
        this.image = image;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
