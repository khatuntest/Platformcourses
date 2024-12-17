package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Model.Quiz;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    private List<Quiz> quizzes = new ArrayList<>();

    public List<Quiz> getAllQuizzes() {
        return quizzes;
    }

    public Quiz createQuiz(Quiz quiz) {
        quizzes.add(quiz);
        return quiz;
    }

    public Quiz getQuizById(Long id) {
        return quizzes.stream()
                .filter(q -> q.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
