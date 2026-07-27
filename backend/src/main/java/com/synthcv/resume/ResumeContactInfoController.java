package com.synthcv.resume;

import com.synthcv.auth.User;
import com.synthcv.auth.UserRepository;
import com.synthcv.resume.dto.ResumeContactInfoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST controller for managing resume contact information.
 */
@RestController
@RequestMapping("/api/resume/contact")
public class ResumeContactInfoController {

    @Autowired
    private ResumeContactInfoService resumeContactInfoService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Get contact information for the authenticated user.
     */
    @GetMapping
    public ResponseEntity<ResumeContactInfoDTO> getContactInfo(@AuthenticationPrincipal User user) {
        Optional<ResumeContactInfo> contactInfo = resumeContactInfoService.findByUserId(user.getId());
        if (contactInfo.isPresent()) {
            ResumeContactInfo info = contactInfo.get();
            ResumeContactInfoDTO dto = new ResumeContactInfoDTO(
                    info.getEmail(),
                    info.getPhoneNumber(),
                    info.getLocation(),
                    info.getLinkedinUrl(),
                    info.getGithubUrl(),
                    info.getPortfolioUrl()
            );
            return ResponseEntity.ok(dto);
        } else {
            // Return empty DTO if no contact info exists
            return ResponseEntity.ok(new ResumeContactInfoDTO());
        }
    }

    /**
     * Save or update contact information for the authenticated user.
     */
    @PostMapping
    public ResponseEntity<?> saveContactInfo(@AuthenticationPrincipal User user,
                                             @Valid @RequestBody ResumeContactInfoDTO contactInfoDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        // Get or create contact info for user
        ResumeContactInfo contactInfo = resumeContactInfoService.findByUserId(user.getId())
                .orElse(new ResumeContactInfo());

        // Update contact info with DTO values
        contactInfo.setUser(user);
        contactInfo.setEmail(contactInfoDTO.getEmail());
        contactInfo.setPhoneNumber(contactInfoDTO.getPhoneNumber());
        contactInfo.setLocation(contactInfoDTO.getLocation());
        contactInfo.setLinkedinUrl(contactInfoDTO.getLinkedinUrl());
        contactInfo.setGithubUrl(contactInfoDTO.getGithubUrl());
        contactInfo.setPortfolioUrl(contactInfoDTO.getPortfolioUrl());

        ResumeContactInfo saved = resumeContactInfoService.save(user.getId(), contactInfo);
        
        // Return updated DTO
        ResumeContactInfoDTO responseDTO = new ResumeContactInfoDTO(
                saved.getEmail(),
                saved.getPhoneNumber(),
                saved.getLocation(),
                saved.getLinkedinUrl(),
                saved.getGithubUrl(),
                saved.getPortfolioUrl()
        );
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * Delete contact information for the authenticated user.
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteContactInfo(@AuthenticationPrincipal User user) {
        resumeContactInfoService.deleteByUserId(user.getId());
        return ResponseEntity.noContent().build();
    }
}