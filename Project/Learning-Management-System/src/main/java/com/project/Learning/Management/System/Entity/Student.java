package com.project.Learning.Management.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
//@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("STUDENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Student extends User {
    // Many-to-Many Relationship with Courses
    @ManyToMany
    @JoinTable(
            name = "Student_Courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Courses> enrolledCourses = new ArrayList<>();



    // Many-to-Many Relationship with Assignments
    @ManyToMany
    @JoinTable(
            name = "Student_Assignments",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "assignment_id")
    )
    private List<Assignment> submittedAssignments = new ArrayList<>();

    // Many-to-Many Relationship with Quizzes
    @ManyToMany
    @JoinTable(
            name = "Student_Quizzes",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id")
    )
    private List<Quiz> takenQuizzes = new ArrayList<>();

    public Student() {
        // JPA requires this constructor
    }

    // Constructor for creating a new student
    public Student(String name, String email, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole("student"); // Default role is "student"
    }

    // Methods to enroll, submit, and take actions
    public void enrollInCourse(Courses course) {
        enrolledCourses.add(course);
    }

    public void submitAssignment(Assignment assignment) {
        submittedAssignments.add(assignment);
    }

    public void takeQuiz(Quiz quiz) {
        takenQuizzes.add(quiz);
    }

    // Utility methods for retrieving unmodifiable lists
    public List<Courses> getEnrolledCourses() {
        return List.copyOf(enrolledCourses);
    }

    public List<Assignment> getSubmittedAssignments() {
        return List.copyOf(submittedAssignments);
    }

    public List<Quiz> getTakenQuizzes() {
        return List.copyOf(takenQuizzes);
    }
}
