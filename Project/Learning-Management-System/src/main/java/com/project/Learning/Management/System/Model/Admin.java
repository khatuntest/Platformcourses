package com.project.Learning.Management.System.Model;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Admin implements User {
    private static List<User> users = new ArrayList<>();
    private static List<String> courses = new ArrayList<>();
    private static String systemSettings = "Default Settings";



    // Create a new user
    public void createUser(User user) {
        users.add(user);
        System.out.println("Admin created a new user: " + user.getUsername());
    }

    // Create a new course
    public void createCourse(String courseName) {
        courses.add(courseName);
        System.out.println("Admin created a new course: " + courseName);
    }

    // Update system settings
    public void updateSystemSettings(String newSettings) {
        systemSettings = newSettings;
        System.out.println("System settings updated: " + newSettings);
    }

    // Get list of users
    public List<User> getUsers() {
        return users;
    }

    // Get list of courses
    public List<String> getCourses() {
        return courses;
    }

    // Get system settings
    public String getSystemSettings() {
        return systemSettings;
    }

    @Override
    public String getFullName() {
        return "";
    }

    @Override
    public void setFullName(String s) {

    }

    @Override
    public Iterator<Group> getGroups() {
        return null;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public void setPassword(String s) {

    }

    @Override
    public Iterator<Role> getRoles() {
        return null;
    }

    @Override
    public UserDatabase getUserDatabase() {
        return null;
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public void setUsername(String s) {

    }

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public boolean isInGroup(Group group) {
        return false;
    }

    @Override
    public boolean isInRole(Role role) {
        return false;
    }

    @Override
    public void removeGroup(Group group) {

    }

    @Override
    public void removeGroups() {

    }

    @Override
    public void removeRole(Role role) {

    }

    @Override
    public void removeRoles() {

    }

    @Override
    public boolean equals(Object another) {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }
}
