package com.project.Learning.Management.System.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "Courses") // Maps to the Courses table in the DB
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremented ID for Courses table
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "duration", nullable = true)
    private String duration;

    // Bi-directional relationship with Node (student table)
    @ManyToMany(mappedBy = "enrolledCourses")
    private List<User> enrolledStudents = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assignment> assignments = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "Media_Files", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "file_path")
    private List<String> mediaFiles = new ArrayList<>();

    // Constructors
    public Courses() {
    }

    public Courses(Long id, String title, String description, String duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
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

    public List<User> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<User> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<String> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(List<String> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    // Methods to add related entities
    public void addMediaFile(String file) {
        this.mediaFiles.add(file);
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void addStudent(User student) {
        this.enrolledStudents.add(student);
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

    public void addQuiz(Quiz quiz) {
        this.quizzes.add(quiz);
    }

    // Utility methods to get enrolled students' names
    public List<String> getEnrolledStudentsNames() {
        return enrolledStudents.stream()
                .map(User::getName)  // Assuming Node class has a `getName` method
                .collect(Collectors.toList());

    }
}
