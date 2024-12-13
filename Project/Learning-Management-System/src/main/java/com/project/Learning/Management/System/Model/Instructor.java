package com.project.Learning.Management.System.Model;

public class Instructor extends User {
    public Instructor(String id, String name, String email, String password) {
        super(id, name, email, password, "instructor");
    }
}
