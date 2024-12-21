package com.project.Learning.Management.System.Service;

import com.project.Learning.Management.System.Entity.Assignment;
import com.project.Learning.Management.System.Entity.Courses;
import com.project.Learning.Management.System.Entity.Quiz;
import com.project.Learning.Management.System.Entity.Student;
import com.project.Learning.Management.System.Repository.StudentRepository;
import com.project.Learning.Management.System.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    private Student student;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        student = new Student("John Doe", "johndoe@example.com", "password123");
    }

    @Test
    void testEnrollStudentInCourse_Success() {
        Courses course = new Courses(); // Initialize with appropriate values
        when(studentRepository.findById(student.getId())).thenReturn(java.util.Optional.of(student));
        when(studentRepository.save(student)).thenReturn(student);

        boolean result = studentService.enrollStudentInCourse(student.getId(), course);
        assertTrue(result);
        assertTrue(student.getEnrolledCourses().contains(course));
    }

    @Test
    void testEnrollStudentInCourse_Failure() {
        Courses course = new Courses();
        when(studentRepository.findById(student.getId())).thenReturn(java.util.Optional.empty());

        boolean result = studentService.enrollStudentInCourse(student.getId(), course);
        assertFalse(result);
    }

    @Test
    void testSubmitStudentAssignment_Success() {
        Assignment assignment = new Assignment(); // Initialize with appropriate values
        when(studentRepository.findById(student.getId())).thenReturn(java.util.Optional.of(student));
        when(studentRepository.save(student)).thenReturn(student);

        boolean result = studentService.submitStudentAssignment(student.getId(), assignment);
        assertTrue(result);
        assertTrue(student.getSubmittedAssignments().contains(assignment));
    }

    @Test
    void testTakeStudentQuiz_Success() {
        Quiz quiz = new Quiz(); // Initialize with appropriate values
        when(studentRepository.findById(student.getId())).thenReturn(java.util.Optional.of(student));
        when(studentRepository.save(student)).thenReturn(student);

        boolean result = studentService.takeStudentQuiz(student.getId(), quiz);
        assertTrue(result);
        assertTrue(student.getTakenQuizzes().contains(quiz));
    }
}
