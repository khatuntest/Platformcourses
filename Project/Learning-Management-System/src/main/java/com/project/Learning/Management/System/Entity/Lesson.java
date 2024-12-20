package com.project.Learning.Management.System.Entity;

import jakarta.persistence.*;
import java.security.SecureRandom;

@Entity
@Table(name = "Lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the id
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "otp", length = 10)
    private String otp;  // OTP for attendance
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Courses course;  // Many lessons belong to one course
    // Constructors
    public Lesson() {}
    public Lesson(Long id, String name, Courses course) {
        this.id = id;
        this.name = name;
        this.course = course;
        generateOTP();  // Generate OTP upon creation
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOtp() {
        return otp;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }
    public Courses getCourse() {
        return course;
    }
    public void setCourse(Courses course) {
        this.course = course;
    }
    public void generateOTP() {
        SecureRandom random = new SecureRandom();
        this.otp = String.format("%04d", random.nextInt(10000)); // 4-digit OTP
    }
}
