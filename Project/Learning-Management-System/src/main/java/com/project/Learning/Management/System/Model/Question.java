package com.project.Learning.Management.System.Model;

import java.util.List;

public class Question {
    private Long id;
    private String questionText;
    private QuestionType questionType; // MCQ, TRUE_FALSE, SHORT_ANSWER
    private List<String> options; // For MCQ
    private String correctAnswer;

    public enum QuestionType {
        MCQ,
        TRUE_FALSE,
        SHORT_ANSWER
    }

    // Constructors
    public Question() {}

    public Question(Long id, String questionText, QuestionType questionType, List<String> options, String correctAnswer) {
        this.id = id;
        this.questionText = questionText;
        this.questionType = questionType;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
