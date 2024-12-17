package com.project.Learning.Management.System.Model;

public class Assignment {
    private Long id;
    private String title;
    private String description;
    private String submissionLink; // Link where students submit their files
    private String feedback;
    private Double grade;

    // Constructors
    public Assignment() {}

    public Assignment(Long id, String title, String description, String submissionLink) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.submissionLink = submissionLink;
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

    public String getSubmissionLink() {
        return submissionLink;
    }

    public void setSubmissionLink(String submissionLink) {
        this.submissionLink = submissionLink;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
