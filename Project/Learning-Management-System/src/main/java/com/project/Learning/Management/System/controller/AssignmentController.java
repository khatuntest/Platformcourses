package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Model.Assignment;
import com.project.Learning.Management.System.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // Submit an assignment
    @PostMapping("/submit")
    public ResponseEntity<Assignment> submitAssignment(@RequestBody Assignment assignment) {
        Assignment savedAssignment = assignmentService.submitAssignment(assignment);
        return ResponseEntity.ok(savedAssignment);
    }

    // Grade and provide feedback
    @PutMapping("/{id}/grade")
    public ResponseEntity<Assignment> gradeAssignment(@PathVariable Long id, @RequestBody Assignment updatedAssignment) {
        Assignment gradedAssignment = assignmentService.gradeAssignment(id, updatedAssignment.getGrade(), updatedAssignment.getFeedback());
        if (gradedAssignment != null) {
            return ResponseEntity.ok(gradedAssignment);
        }
        return ResponseEntity.notFound().build(); // Return 404 if assignment not found
    }

    // Get all assignments
    @GetMapping
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        List<Assignment> assignments = assignmentService.getAllAssignments();
        return ResponseEntity.ok(assignments);
    }

    // Get assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        Assignment assignment = assignmentService.getAssignmentById(id);
        if (assignment != null) {
            return ResponseEntity.ok(assignment);
        }
        return ResponseEntity.notFound().build(); // Return 404 if assignment not found
    }
}
