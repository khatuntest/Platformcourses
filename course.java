package com.learning.courses.model;

import java.util.ArrayList;
import java.util.List;

public class course {
    private Long id;
    private String title;
    private String description;
    private String duration;
    private List<String> enrolledStudents;
    private List<Lesson> lessons;
    private List<String> mediaFiles;  // List to store media files (URLs or paths)

    public course(Long id, String title, String description, String duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.enrolledStudents = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.mediaFiles = new ArrayList<>();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<String> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(List<String> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public void addMediaFile(String file) {
        this.mediaFiles.add(file);
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void addStudent(String student) {
        this.enrolledStudents.add(student);
    }
}

