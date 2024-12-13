package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Model.Assignment;
import com.project.Learning.Management.System.Model.Courses;
import com.project.Learning.Management.System.Model.Quiz;
import com.project.Learning.Management.System.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private final List<Student> students = new ArrayList<>();

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Enroll a student in a course
    public boolean enrollStudentInCourse(String studentId, Courses course) {
        Student student = findStudentById(studentId);
        if (student != null) {
            // Check if the course is already enrolled
            if (!student.getEnrolledCourses().contains(course)) {
                student.enrollInCourse(course);
                return true; // Successfully enrolled
            }
        }
        return false; // Either student not found or already enrolled
    }

    // Submit an assignment
    public boolean submitStudentAssignment(String studentId, Assignment assignment) {
        Student student = findStudentById(studentId);
        if (student != null) {
            student.submitAssignment(assignment);
            return true;
        }
        return false; // Student not found
    }

    // Take a quiz
    public boolean takeStudentQuiz(String studentId, Quiz quiz) {
        Student student = findStudentById(studentId);
        if (student != null) {
            student.takeQuiz(quiz);
            return true;
        }
        return false; // Student not found
    }


    // Find a student by ID
    public Student findStudentById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }
}
