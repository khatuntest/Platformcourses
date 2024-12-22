package com.project.Learning.Management.System.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity // تحديد الكلاس ككيان
@Table(name = "Notifications") // اسم الجدول في قاعدة البيانات
public class Notification {

    @Id // تحديد المفتاح الأساسي
    private String id;

    @Column(name = "user_id", nullable = false) // تحديد اسم العمود وأنه لا يمكن أن يكون فارغاً
    private String userId;

    @Column(nullable = false)
    private String message;

    @Column(name = "is_read", nullable = false)
    private boolean isRead;

    @Column(name = "notification_date", nullable = false)
    private LocalDateTime notificationDate; // إضافة حقل للتاريخ

    // Constructor فارغ مطلوب لـ JPA
    public Notification() {
    }

    // Constructor الأساسي
    public Notification(String id, String userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.isRead = false;
        this.notificationDate = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }
}