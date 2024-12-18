package com.project.Learning.Management.System.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "Assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "submission_link")
    private String submissionLink;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "grade")
    private Double grade;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Courses course;

    // Constructors
    public Assignment() {}

    public Assignment(Long id, String title, String description,
                      String submissionLink, String feedback,
                      Double grade, Courses course) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.submissionLink = submissionLink;
        this.feedback = feedback;
        this.grade = grade;
        this.course = course;
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

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }



}
