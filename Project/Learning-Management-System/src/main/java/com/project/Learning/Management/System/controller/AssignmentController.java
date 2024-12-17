package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Model.Assignment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private List<Assignment> assignments = new ArrayList<>();

    // Submit an assignment
    @PostMapping("/submit")
    public ResponseEntity<Assignment> submitAssignment(@RequestBody Assignment assignment) {
        assignments.add(assignment);
        return ResponseEntity.ok(assignment);
    }

    // Grade and provide feedback
    @PutMapping("/{id}/grade")
    public ResponseEntity<Assignment> gradeAssignment(@PathVariable Long id, @RequestBody Assignment updatedAssignment) {
        for (Assignment assignment : assignments) {
            if (assignment.getId().equals(id)) {
                assignment.setGrade(updatedAssignment.getGrade());
                assignment.setFeedback(updatedAssignment.getFeedback());
                return ResponseEntity.ok(assignment);
            }
        }
        return ResponseEntity.notFound().build();
    }
}