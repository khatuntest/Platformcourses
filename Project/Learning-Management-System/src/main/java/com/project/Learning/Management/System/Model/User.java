package com.project.Learning.Management.System.Model;


import java.util.ArrayList;
import java.util.List;
public abstract class User {
    private static List<Node> students = new ArrayList<>();
    private static List<Node> admins = new ArrayList<>();
    private static List<Node> instructors = new ArrayList<>();
    User(String id, String name, String email, String password, String role) {
        Node node = new Node(id, name, email, password, role);
        if (role.equals("student")) {
            students.add(node);
        }
        else if (role.equals("admin")) {
            admins.add(node);
        }
        else if (role.equalsIgnoreCase("instructor")) {
        instructors.add(node);
        }
        else {
        throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
    // Getters for the lists
    public static List<Node> getStudents() {
        return students;
    }
    public static List<Node> getAdmins() {
        return admins;
    }
    public static List<Node> getInstructors() {
        return instructors;
    }
}
