package com.project.Learning.Management.System.Model;


import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private Node node;

    // Static lists for user management
    public static  List<Node> students = new ArrayList<>();
    public static  List<Node> admins = new ArrayList<>();
    public static  List<Node> instructors = new ArrayList<>();

    // Constructor
    public User(String id, String name, String email, String password, String role) {
        this.node = new Node(id, name, email, password, role);

        // Add user to the appropriate list
        if (role.equalsIgnoreCase("student")) {
            students.add(node);
        } else if (role.equalsIgnoreCase("admin")) {
            admins.add(node);
        } else if (role.equalsIgnoreCase("instructor")) {
            instructors.add(node);
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    // Delegate getters to the Node class
    public String getId() {
        return node.getId();
    }

    public String getName() {
        return node.getName();
    }

    public String getEmail() {
        return node.getEmail();
    }

    public String getRole() {
        return node.getRole();
    }

    // Static getters for lists
    public static  List<Node> getStudents() {
        return students;
    }

    public static List<Node> getAdmins() {
        return admins;
    }

    public static List<Node> getInstructors() {
        return instructors;
    }
}