package com.example.recyclerview;

public class NotesInfo {

    private String title;
    private String course;

    public NotesInfo(String title, String course) {
        this.title = title;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


}
