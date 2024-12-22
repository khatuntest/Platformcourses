package com.project.Learning.Management.System.service;
import com.project.Learning.Management.System.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(String userId);

    List<Notification> findByUserIdAndIsRead(String userId, boolean b);
}