//package com.project.Learning.Management.System.Model;
//
//public class Courses {
//    public void enrollInCourse(Courses course ){}
//}

package com.project.Learning.Management.System.Model;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    private String id;
    private String title;
    private String description;
    private List<User> enrolledStudents = new ArrayList<>();

    // Constructor, Getters, and Setters
    public Courses(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<User> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents);
    }

    public void enrollStudent(User student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }
}
