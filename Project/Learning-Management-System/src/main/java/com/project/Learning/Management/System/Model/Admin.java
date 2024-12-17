package com.project.Learning.Management.System.Model;


import java.util.List;

public class Admin extends User {
    // Constructor
    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password, "admin");
    }

    public String viewAllUsers() {
        StringBuilder userList = new StringBuilder("Users in the system:\n");

        List<Node> students = User.getStudents();
        List<Node> instructors = User.getInstructors();
        List<Node> admins = User.getAdmins();

        userList.append("\nAdmins:\n");
        admins.forEach(user -> userList.append(user.getName()).append(" (").append(user.getEmail()).append(")\n"));

        userList.append("\nInstructors:\n");
        instructors.forEach(user -> userList.append(user.getName()).append(" (").append(user.getEmail()).append(")\n"));

        userList.append("\nStudents:\n");
        students.forEach(user -> userList.append(user.getName()).append(" (").append(user.getEmail()).append(")\n"));

        return userList.toString();
    }

}