package com.project.Learning.Management.System.service;
import org.apache.catalina.User;

import java.util.List;

public class Authentication {

    // Method to authenticate user credentials
    public static boolean authenticate(String username, String password, List<User> userList) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Valid credentials
            }
        }
        return false; // Invalid credentials
    }
}
