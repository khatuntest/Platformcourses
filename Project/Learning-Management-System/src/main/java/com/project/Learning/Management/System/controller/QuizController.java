package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Entity.Question;
import com.project.Learning.Management.System.Entity.Quiz;
import com.project.Learning.Management.System.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Endpoint to get all quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    // Endpoint to create a quiz
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.createQuiz(quiz));
    }

    // Endpoint to get randomized questions for a quiz attempt
    @GetMapping("/{id}/attempt")
    public ResponseEntity<List<Question>> getRandomizedQuiz(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null) {
            List<Question> randomQuestions = quiz.getRandomQuestions();
            return ResponseEntity.ok(randomQuestions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
