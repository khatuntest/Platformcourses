package com.project.Learning.Management.System.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String username;
    private String password;
    private String role;
    private String email;

    private static List<Node> students = new ArrayList<>();
    private static List<Node> admins = new ArrayList<>();
    private static List<Node> instructors = new ArrayList<>();

    // Constructor
    public User(String id, String name, String email, String password, String role) {
        Node node = new Node(id, name, email, password, role);
        switch (role.toLowerCase()) {
            case "student":
                students.add(node);
                break;
            case "admin":
                admins.add(node);
                break;
            case "instructor":
                instructors.add(node);
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
