package com.project.Learning.Management.System.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Foreign key to the Users table
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "department")
    private String department;

    @Column(name = "expertise")
    private String expertise;

    // One-to-many relationship with created courses
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Courses> createdCourses = new ArrayList<>();

    // Constructor
    public Instructor(String name, String email, String password, String department, String expertise) {
        super(name, email, password, "instructor");
        this.department = department;
        this.expertise = expertise;
    }

    // Default constructor for JPA
    public Instructor() {
        super();
    }

    // Method to create a course
    public Courses createCourse(String title, String description, String duration) {
        Courses course = new Courses((long) (createdCourses.size() + 1), title, description, duration);
        createdCourses.add(course);
        return course;
    }

    // Add content to a course
    public void addContentToCourse(Courses course, String mediaFile) {
        course.addMediaFile(mediaFile);
    }

    // Add a lesson to a course
    public void addLessonToCourse(Courses course, Lesson lesson) {
        course.addLesson(lesson);
    }

    // Add an assignment to a course
    public void addAssignmentToCourse(Courses course, Assignment assignment) {
        course.getAssignments().add(assignment);
    }

    // Add a quiz to a course
    public void addQuizToCourse(Courses course, Quiz quiz) {
        course.getQuizzes().add(quiz);
    }

    // Remove a student from a course
    public void removeStudentFromCourse(Courses course, String studentId) {
        course.getEnrolledStudents().remove(studentId);
    }

    // Getters for instructor details
    public Long getId() {
        return super.getId();
    }

    public String getName() {
        return super.getName();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public List<Courses> getCreatedCourses() {
        return createdCourses;
    }

    public String getDepartment() {
        return department;
    }

    public String getExpertise() {
        return expertise;
    }

    // Setters
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}
