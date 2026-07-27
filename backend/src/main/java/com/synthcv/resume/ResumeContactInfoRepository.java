package com.synthcv.resume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for ResumeContactInfo entity.
 */
@Repository
public interface ResumeContactInfoRepository extends JpaRepository<ResumeContactInfo, Long> {
    // Find by user ID
    ResumeContactInfo findByUserId(Long userId);
}