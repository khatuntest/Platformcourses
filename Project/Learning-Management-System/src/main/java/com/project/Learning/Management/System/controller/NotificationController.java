package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Model.Notification;
import com.project.Learning.Management.System.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

//    @PostMapping("/add")
//    public void addNotification(@RequestBody Notification notification) {
//        notificationService.addNotification(notification);
//    }

    @GetMapping("/unread/{userId}")
    public List<Notification> getUnreadNotifications(@PathVariable String userId) {
        return notificationService.getUnreadNotifications(userId);
    }

    @GetMapping("/all/{userId}")
    public List<Notification> getUserNotifications(@PathVariable String userId) {
        return notificationService.getUserNotifications(userId);
    }

    @PutMapping("/markAsRead/{notificationId}")
    public void markAsRead(@PathVariable String notificationId) {
        notificationService.markAsRead(notificationId);
    }
}