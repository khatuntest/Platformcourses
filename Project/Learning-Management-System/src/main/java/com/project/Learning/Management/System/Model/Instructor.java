package com.project.Learning.Management.System.Model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Instructor extends User {
    private static Map<String, List<String>> courseContents = new HashMap<>();
    private static Map<String, String> assignments = new HashMap<>();
    private static Map<Long, Integer> studentGrades = new HashMap<>();

    public Instructor(String id, String username, String email, String password) {
        super(id, username, email, password, "Instructor");
    }

    // Add content to a course
    public void addCourseContent(String courseId, String content) {
        courseContents.putIfAbsent(courseId, new ArrayList<>());
        courseContents.get(courseId).add(content);
        System.out.println("Content added to course " + courseId + ": " + content);
    }

    // Add an assignment
    public void addAssignment(String courseId, String assignmentDetails) {
        assignments.put(courseId, assignmentDetails);
        System.out.println("Assignment added to course " + courseId + ": " + assignmentDetails);
    }

    // Grade a student
    public void gradeStudent(Long studentId, int grade) {
        studentGrades.put(studentId, grade);
        System.out.println("Graded student " + studentId + " with grade: " + grade);
    }

    // Get course contents
    public List<String> getCourseContent(String courseId) {
        return courseContents.getOrDefault(courseId, new ArrayList<>());
    }

    // Get assignments
    public String getAssignment(String courseId) {
        return assignments.get(courseId);
    }

    // Get student grades
    public Integer getGrade(Long studentId) {
        return studentGrades.get(studentId);
    }
}
