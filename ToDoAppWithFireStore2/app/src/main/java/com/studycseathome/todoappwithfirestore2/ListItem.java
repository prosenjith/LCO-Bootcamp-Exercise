package com.studycseathome.todoappwithfirestore2;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

public class ListItem implements Serializable {
    private String title,description;
    @Exclude private String id;
    public ListItem(){

    }
    public ListItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
