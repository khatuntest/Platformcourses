package com.project.Learning.Management.System.Model;

import java.util.ArrayList;
import java.util.List;


public class Student {
    // Attributes
    private Node node; // Contains id, name, email, password, and role
    private List<Courses> enrolledCourses = new ArrayList<>();
    private List<Assignment> submittedAssignments = new ArrayList<>();
    private List<Quiz> takenQuizzes = new ArrayList<>();

    // Constructor
    public Student(String id, String name, String email, String password, String student) {
        this.node = new Node(id, name, email, password, "student");
    }

    // Enroll in a course
    public void enrollInCourse(Courses course) {
        enrolledCourses.add(course);
    }

    // Submit an assignment
    public void submitAssignment(Assignment assignment) {
        submittedAssignments.add(assignment);
    }

    // Take a quiz
    public void takeQuiz(Quiz quiz) {
        takenQuizzes.add(quiz);
    }

    // Getters delegating to Node
    public String getId() {
        return node.getId();
    }

    public String getName() {
        return node.getName();
    }

    public String getEmail() {
        return node.getEmail();
    }
    // Getters for lists
    public List<Courses> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }

    public List<Assignment> getSubmittedAssignments() {
        return new ArrayList<>(submittedAssignments);
    }

    public List<Quiz> getTakenQuizzes() {
        return new ArrayList<>(takenQuizzes);
    }
}