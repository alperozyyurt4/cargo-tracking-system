package com.example.userservice.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProfileRequest {
    private String email;
    private String fullName;
    private String phone;
}
