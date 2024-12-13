package com.project.Learning.Management.System.Model;


public class Admin extends User {
    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password, "admin");
    }
}