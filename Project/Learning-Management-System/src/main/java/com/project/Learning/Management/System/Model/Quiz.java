package com.project.Learning.Management.System.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {
    private Long id;
    private String title;
    private String description;
    private List<Question> questionBank; // Pool of questions
    private int numberOfQuestions;

    // Constructors
    public Quiz() {}

    public Quiz(Long id, String title, String description, List<Question> questionBank, int numberOfQuestions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questionBank = questionBank;
        this.numberOfQuestions = numberOfQuestions;
    }

    // Randomized question selection
    public List<Question> getRandomQuestions() {
        if (questionBank == null || questionBank.isEmpty()) {
            throw new IllegalStateException("Question bank is empty.");
        }
        List<Question> copy = new ArrayList<>(questionBank);
        Collections.shuffle(copy);
        return copy.stream().limit(numberOfQuestions).
                collect(Collectors.toList());
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

    public List<Question> getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(List<Question> questionBank) {
        this.questionBank = questionBank;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}