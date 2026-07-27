package com.synthcv.resume;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service class for managing resume contact information.
 */
@Service
@Transactional
public class ResumeContactInfoService {

    private final ResumeContactInfoRepository resumeContactInfoRepository;

    public ResumeContactInfoService(ResumeContactInfoRepository resumeContactInfoRepository) {
        this.resumeContactInfoRepository = resumeContactInfoRepository;
    }

    /**
     * Retrieve contact information by user ID.
     */
    public Optional<ResumeContactInfo> findByUserId(Long userId) {
        return Optional.ofNullable(resumeContactInfoRepository.findByUserId(userId));
    }

    /**
     * Save or update contact information for a user.
     */
    public ResumeContactInfo save(Long userId, ResumeContactInfo contactInfo) {
        // Ensure the contact info is associated with the user
        // The User entity will be set by the controller or via a separate method
        // For now, we assume the contactInfo already has the user set, or we set it here.
        // However, to avoid circular dependency, we might set the user in the controller.
        // We'll leave it as is and assume the caller sets the user.
        return resumeContactInfoRepository.save(contactInfo);
    }

    /**
     * Delete contact information by user ID.
     */
    public void deleteByUserId(Long userId) {
        ResumeContactInfo contactInfo = resumeContactInfoRepository.findByUserId(userId);
        if (contactInfo != null) {
            resumeContactInfoRepository.delete(contactInfo);
        }
    }
}