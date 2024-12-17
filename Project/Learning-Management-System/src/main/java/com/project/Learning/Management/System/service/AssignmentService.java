package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Model.Assignment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentService {

    private final List<Assignment> assignments = new ArrayList<>();

    // Add or submit a new assignment
    public Assignment submitAssignment(Assignment assignment) {
        assignment.setId((long) (assignments.size() + 1)); // Generate ID
        assignments.add(assignment);
        return assignment;
    }

    // Get all assignments
    public List<Assignment> getAllAssignments() {
        return assignments;
    }

    // Get assignment by ID
    public Assignment getAssignmentById(Long id) {
        return assignments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Grade and provide feedback for a submitted assignment
    public Assignment gradeAssignment(Long id, Double grade, String feedback) {
        Assignment assignment = getAssignmentById(id);
        if (assignment != null) {
            assignment.setGrade(grade);
            assignment.setFeedback(feedback);
        }
        return assignment;
    }
}