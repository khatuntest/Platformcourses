package com.project.Learning.Management.System.Model;

import com.project.Learning.Management.System.service.NotificationService;

import java.util.UUID;

public class Courses {
    private final NotificationService notificationService = new NotificationService();
    public void enrollInCourse(Courses course ){}



    public void enrollStudent(String studentId, String courseId, String instructorId) {
            // منطق تسجيل الطالب في الكورس
            // ...

            // إرسال إشعار للمدرس
        String message = "A new student (ID: " + studentId + ") has enrolled in the course: " + courseId;
        Notification notification = new Notification(
                    UUID.randomUUID().toString(),
                    instructorId,
                    message
            );
            notificationService.addNotification(notification);
        }
    }






}
