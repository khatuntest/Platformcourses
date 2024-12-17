package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Model.Courses;
import com.project.Learning.Management.System.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

//import static java.util.stream.Nodes.collect;

//import static java.util.stream.Nodes.collect;

@Service
public class AdminService {

    private final List<User> users = new ArrayList<>();
    private final List<Courses> courses = new ArrayList<>();

    // Create new user
    public boolean createUser(User user) {
        if (users.stream().noneMatch(u -> u.getEmail().equals(user.getEmail()))) {
            users.add(user);
            return true;
        }
        return false; // User with the same email already exists
    }

    // Create new course
    public boolean createCourse(Courses course) {
        if (courses.stream().noneMatch(c -> c.getTitle().equals(course.getTitle()))) {
            courses.add(course);
            return true;
        }
        return false; // Course with the same title already exists
    }

    // Get a list of students enrolled in a course
    public List<String> getEnrolledStudents(String courseId) {
        Courses course = courses.stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst()
                .orElse(null);

        if (course != null) {
            return course.getEnrolledStudents();  // Directly return the list of student names (List<String>)
        }
        return new ArrayList<>(); // Course not found or no enrolled students
    }


    // Generate a performance report
    public String generatePerformanceReport() {
        return "Performance report generated (placeholder).";
    }
}