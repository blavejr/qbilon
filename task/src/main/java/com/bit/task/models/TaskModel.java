package com.bit.task.models;

public class TaskModel {
    private String title;
    private String description;
    private String id;

    public TaskModel() {
    }

    public TaskModel(String title, String description, String id) {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }
}
