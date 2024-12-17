package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Model.Courses;
import com.project.Learning.Management.System.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    // Create a course
    @PostMapping("/{id}/createCourse")
    public String createCourse(@PathVariable Long id, @RequestBody Courses courseDetails) {
        Courses course = instructorService.createCourse(id, courseDetails.getTitle(), courseDetails.getDescription(), courseDetails.getDuration());
        if (course != null) {
            return "Course created successfully: " + course.getTitle();
        }
        return "Failed to create course.";
    }

    // Add content to a course
    @PostMapping("/{id}/addContent")
    public String addContent(@PathVariable Long id, @RequestBody Courses course, @RequestParam String mediaFile) {
        boolean added = instructorService.addContent(id, course, mediaFile);
        if (added) {
            return "Content added to course: " + course.getTitle();
        }
        return "Failed to add content to course.";
    }

    // Remove a student from a course
    @DeleteMapping("/{id}/removeStudent")
    public String removeStudent(@PathVariable Long id, @RequestBody Courses course, @RequestParam String studentId) {
        boolean removed = instructorService.removeStudent(id, course, studentId);
        if (removed) {
            return "Student with ID " + studentId + " removed from course: " + course.getTitle();
        }
        return "Failed to remove student from course.";
    }
}
