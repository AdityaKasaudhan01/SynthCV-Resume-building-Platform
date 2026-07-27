package com.synthcv.resume.dto;

import jakarta.validation.constraints.Pattern;

/**
 * Data Transfer Object for resume contact information.
 * Used for transferring data between client and server.
 */
public class ResumeContactInfoDTO {

    // Pattern allows empty string or a valid email format
    @Pattern(regexp = "^(|[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+)$", message = "Email should be valid")
    private String email;

    // Empty or valid phone (10-13 digits with optional leading +)
    @Pattern(regexp = "^(|\\+?[0-9]{10,13})$", message = "Phone number should be valid")
    private String phoneNumber;

    // Location is free text, no pattern needed
    private String location;

    // LinkedIn URL: empty or valid LinkedIn profile URL
    @Pattern(regexp = "^(|(https?://)?(www\\.)?linkedin\\.com/in/[a-zA-Z0-9_-]+)$", message = "LinkedIn URL should be valid")
    private String linkedinUrl;

    // GitHub URL: empty or valid GitHub profile URL
    @Pattern(regexp = "^(|(https?://)?(www\\.)?github\\.com/[a-zA-Z0-9_-]+)$", message = "GitHub URL should be valid")
    private String githubUrl;

    // Portfolio URL: empty or valid URL
    @Pattern(regexp = "^(|(https?://)?[a-zA-Z0-9][-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[a-zA-Z0-9])$", message = "Portfolio URL should be valid")
    private String portfolioUrl;

    // Default constructor
    public ResumeContactInfoDTO() {}

    // Parameterized constructor
    public ResumeContactInfoDTO(String email, String phoneNumber, String location,
                                String linkedinUrl, String githubUrl, String portfolioUrl) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.linkedinUrl = linkedinUrl;
        this.githubUrl = githubUrl;
        this.portfolioUrl = portfolioUrl;
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getLinkedinUrl() { return linkedinUrl; }
    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }

    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }

    public String getPortfolioUrl() { return portfolioUrl; }
    public void setPortfolioUrl(String portfolioUrl) { this.portfolioUrl = portfolioUrl; }
}