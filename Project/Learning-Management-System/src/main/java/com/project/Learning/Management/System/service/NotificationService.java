package com.project.Learning.Management.System.service;
import com.project.Learning.Management.System.Model.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationService {
    private List<Notification> notifications = new ArrayList<>();

    // Add a notification
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    // Get unread notifications for a user
    public List<Notification> getUnreadNotifications(String userId) {
        return notifications.stream()
                .filter(notification -> notification.getUserId().equals(userId) && !notification.isRead())
                .collect(Collectors.toList());
    }

    // Get all notifications for a user
    public List<Notification> getAllNotifications(String userId) {
        return notifications.stream()
                .filter(notification -> notification.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    // Mark a notification as read
    public void markAsRead(String notificationId) {
        notifications.stream()
                .filter(notification -> notification.getId().equals(notificationId))
                .forEach(notification -> notification.setRead(true));
    }
}
