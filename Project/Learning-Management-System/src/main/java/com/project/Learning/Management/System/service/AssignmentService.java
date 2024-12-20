package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Entity.Assignment;
import com.project.Learning.Management.System.Repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment submitAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment); // Persist assignment
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll(); // Get all assignments
    }

    public Assignment getAssignmentById(Long id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        return assignment.orElse(null); // Return assignment or null if not found
    }

    public Assignment gradeAssignment(Long id, Double grade, String feedback) {
        Assignment assignment = getAssignmentById(id);
        if (assignment != null) {
            assignment.setGrade(grade);
            assignment.setFeedback(feedback);
            return assignmentRepository.save(assignment); // Save graded assignment
        }
        return null; // Return null if not found
    }
}
