package com.example.userservice.service;

import com.example.userservice.dto.UserProfileResponse;
import com.example.userservice.dto.UserProfileUpdateRequest;
import com.example.userservice.model.UserProfile;
import com.example.userservice.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileResponse getMyProfile(String email){
        UserProfile user = userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profil bulunamadı: " + email));
        return mapToResponse(user);
    }


    public UserProfileResponse updateMyProfile(String email, UserProfileUpdateRequest request){
        UserProfile user = userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profil bulunamadı" + email));

        user.setFullName(request.getFullName());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());
        user.setDistrict(request.getDistrict());
        user.setZipCode(request.getZipCode());

        userProfileRepository.save(user);
        return mapToResponse(user);
    }

    public void createProfileIfNotExists(String email, String fullName, String phone){
        if (userProfileRepository.findByEmail(email).isEmpty()){
            UserProfile user = UserProfile.builder()
                    .email(email)
                    .fullName(fullName)
                    .phone(phone)
                    .build();
            userProfileRepository.save(user);
        }
    }


    private UserProfileResponse mapToResponse(UserProfile user){
        return UserProfileResponse.builder()
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .city(user.getCity())
                .district(user.getDistrict())
                .zipCode(user.getZipCode())
                .build();
    }

}

