package com.project.Learning.Management.System.Entity;

import jakarta.persistence.*;;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_questions")
    private int numberOfQuestions;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Courses course;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    // Constructors
    public Quiz() {}

    public Quiz(Long id, String title, String description,
                int numberOfQuestions, Courses course,
                List<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.numberOfQuestions = numberOfQuestions;
        this.course = course;
        this.questions = questions;
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

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    // Method to get a shuffled list of random questions for quiz attempt
    public List<Question> getRandomQuestions() {
        Collections.shuffle(questions); // Shuffle questions to randomize
        return questions.subList(0, Math.min(numberOfQuestions, questions.size())); // Return required number of questions
    }
}
