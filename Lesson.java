package com.learning.courses.model;


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

    public void generateOTP() {
        this.otp = String.valueOf((int)(Math.random() * 10000));  // Simple OTP generation
    }
}

