package com.project.Learning.Management.System.Model;

import com.project.Learning.Management.System.service.NotificationService;

import java.util.UUID;

public class Assignment {
    private final NotificationService notificationService = new NotificationService();

    public void gradeAssignment(String studentId, String assignmentName, int grade) {
        // منطق التقييم
        // ...

        // إرسال إشعار للطالب
        String message = "The assignment has been graded " + assignmentName + " grade: " + grade;
        Notification notification = new Notification(
                UUID.randomUUID().toString(),
                studentId,
                message
        );
        notificationService.addNotification(notification);
    }
}

