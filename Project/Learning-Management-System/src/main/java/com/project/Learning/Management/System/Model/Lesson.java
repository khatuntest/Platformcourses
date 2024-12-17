package com.project.Learning.Management.System.Model;

import java.security.SecureRandom;

public class Lesson {
    private Long id;
    private String name;
    private String otp;  // OTP for attendance

    public Lesson(Long id, String name) {
        this.id = id;
        this.name = name;
        generateOTP();  // Generate OTP upon creation
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String GetName() {
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

    public void generateOTP() {
        SecureRandom random = new SecureRandom();
        this.otp = String.format("%04d", random.nextInt(10000));
        // 4-digit OTP
    }
}
