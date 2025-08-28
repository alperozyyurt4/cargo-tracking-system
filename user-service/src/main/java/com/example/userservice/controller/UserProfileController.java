package com.example.userservice.controller;

import com.example.userservice.dto.CreateProfileRequest;
import com.example.userservice.dto.UserProfileResponse;
import com.example.userservice.dto.UserProfileUpdateRequest;
import com.example.userservice.service.UserProfileService;
import com.example.userservice.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final JwtUtil jwtUtil;

    // Get Profile
    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getMyProfile(@RequestHeader("Authorization") String authHeader){
        String email = extractEmail(authHeader);
        UserProfileResponse response = userProfileService.getMyProfile(email);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/me")
    public ResponseEntity<UserProfileResponse> updateMyProfile(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody @Valid UserProfileUpdateRequest request
            ){
        String email = extractEmail(authHeader);
        UserProfileResponse response = userProfileService.updateMyProfile(email,request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-profile")
    public ResponseEntity<Void> createProfile(@RequestBody CreateProfileRequest request){
        userProfileService.createProfileIfNotExists(request.getEmail(), request.getFullName(), request.getPhone());
        return ResponseEntity.ok().build();
    }



    private String extractEmail(String authHeader){
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Geçersiz token");
        }
        String token = authHeader.substring(7);
        return jwtUtil.extractEmail(token);
    }
}
