package com.project.Learning.Management.System.Model;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
    private Node node; // Contains id, name, email, password, and role
    private List<Courses> createdCourses = new ArrayList<>();

    // Constructor
    public Instructor(String id, String name, String email, String password) {
        super(id, name, email, password, "instructor");
    }

    // Create a course
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
    public String getId() {
        return node.getId();
    }

    public String getName() {
        return node.getName();
    }

    public String getEmail() {
        return node.getEmail();
    }

    public List<Courses> getCreatedCourses() {
        return createdCourses;
    }
}
