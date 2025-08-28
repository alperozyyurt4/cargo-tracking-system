package com.example.authservice.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProfileRequest {
    private String email;
    private String fullName;
    private String phone;
}
