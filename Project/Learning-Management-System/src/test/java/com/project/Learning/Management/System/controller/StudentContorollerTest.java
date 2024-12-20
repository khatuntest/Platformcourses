package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Entity.Assignment;
import com.project.Learning.Management.System.Entity.Courses;
import com.project.Learning.Management.System.Entity.Quiz;
import com.project.Learning.Management.System.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEnrollInCourse_Success() {
        int studentId = 1;
        Courses course = new Courses(); // Initialize with appropriate values
        when(studentService.enrollStudentInCourse(studentId, course)).thenReturn(true);

        ResponseEntity<String> response = studentController.enrollInCourse(studentId, course);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Student successfully enrolled in the course.", response.getBody());
    }

    @Test
    void testEnrollInCourse_Failure() {
        int studentId = 1;
        Courses course = new Courses();
        when(studentService.enrollStudentInCourse(studentId, course)).thenReturn(false);

        ResponseEntity<String> response = studentController.enrollInCourse(studentId, course);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Enrollment failed. Course or student may not exist.", response.getBody());
    }

    @Test
    void testSubmitAssignment_Success() {
        int studentId = 1;
        Assignment assignment = new Assignment(); // Initialize with appropriate values
        when(studentService.submitStudentAssignment(studentId, assignment)).thenReturn(true);

        String response = studentController.submitAssignment(studentId, assignment);
        assertEquals("Assignment " + assignment.getTitle() + " submitted by student with ID " + studentId, response);
    }

    @Test
    void testTakeQuiz_Success() {
        int studentId = 1;
        Quiz quiz = new Quiz(); // Initialize with appropriate values
        when(studentService.takeStudentQuiz(studentId, quiz)).thenReturn(true);

        String response = studentController.takeQuiz(studentId, quiz);
        assertEquals("Quiz " + quiz.getTitle() + " taken by student with ID " + studentId, response);
    }
}
