package com.project.Learning.Management.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import java.util.List;

@Entity
public class Admin extends User {
    public Admin(){
        super();
    };
    // Constructor with parameters
    public Admin(String name, String email, String password) {
        super(name, email, password, "admin");
    }

    // Method to view all users (students, instructors, admins) from the database
    public String viewAllUsers(EntityManager entityManager) {
        StringBuilder userList = new StringBuilder("Users in the system:\n");

        // Query to get all students from the database
        List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();

        // Query to get all instructors from the database
        List<Instructor> instructors = entityManager.createQuery("SELECT i FROM Instructor i", Instructor.class).getResultList();

        // Query to get all admins from the database
        List<Admin> admins = entityManager.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();

        // Append Admins
        userList.append("\nAdmins:\n");
        admins.forEach(admin -> userList.append(admin.getName()).append(" (").append(admin.getEmail()).append(")\n"));

        // Append Instructors
        userList.append("\nInstructors:\n");
        instructors.forEach(instructor -> userList.append(instructor.getName()).append(" (").append(instructor.getEmail()).append(")\n"));

        // Append Students
        userList.append("\nStudents:\n");
        students.forEach(student -> userList.append(student.getName()).append(" (").append(student.getEmail()).append(")\n"));

        return userList.toString();
    }
}
