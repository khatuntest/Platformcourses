package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Entity.Instructor;
import com.project.Learning.Management.System.Entity.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService {

    private final List<Instructor> instructors = new ArrayList<>();

    // Add an instructor
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    // Find an instructor by ID
    public Instructor findInstructorById(Long id) {
        return instructors.stream()
                .filter(instructor -> instructor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Create a course
    public Courses createCourse(Long instructorId, String title, String description, String duration) {
        Instructor instructor = findInstructorById(instructorId);
        if (instructor != null) {
            return instructor.createCourse(title, description, duration);
        }
        return null;
    }

    // Add content to a course
    public boolean addContent(Long instructorId, Courses course, String mediaFile) {
        Instructor instructor = findInstructorById(instructorId);
        if (instructor != null) {
            instructor.addContentToCourse(course, mediaFile);
            return true;
        }
        return false;
    }

    // Remove a student from a course
    public boolean removeStudent(Long instructorId, Courses course, String studentId) {
        Instructor instructor = findInstructorById(instructorId);
        if (instructor != null) {
            instructor.removeStudentFromCourse(course, studentId);
            return true;
        }
        return false;
    }
}
