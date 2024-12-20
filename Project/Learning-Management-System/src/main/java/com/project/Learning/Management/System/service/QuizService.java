package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Entity.Quiz;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    private List<Quiz> quizzes = new ArrayList<>(); // In-memory storage (replace with repository for real apps)

    public List<Quiz> getAllQuizzes() {
        return quizzes;
    }

    public Quiz createQuiz(Quiz quiz) {
        quizzes.add(quiz);  // In-memory save (replace with repository for real apps)
        return quiz;
    }

    public Quiz getQuizById(Long id) {
        return quizzes.stream()
                .filter(q -> q.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
