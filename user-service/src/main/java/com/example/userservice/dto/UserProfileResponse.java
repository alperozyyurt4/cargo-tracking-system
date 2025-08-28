package com.example.userservice.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileResponse {
    private String email;
    private String fullName;
    private String phone;
    private String address;
    private String city;
    private String district;
    private String zipCode;

}
