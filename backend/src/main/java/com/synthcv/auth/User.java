package com.synthcv.auth;

import com.synthcv.resume.ResumeContactInfo;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Bidirectional relationship with ResumeContactInfo
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ResumeContactInfo resumeContactInfo;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Getter and setter for resumeContactInfo
    public ResumeContactInfo getResumeContactInfo() { return resumeContactInfo; }
    public void setResumeContactInfo(ResumeContactInfo resumeContactInfo) {
        this.resumeContactInfo = resumeContactInfo;
        if (resumeContactInfo != null) {
            resumeContactInfo.setUser(this);
        }
    }
}
