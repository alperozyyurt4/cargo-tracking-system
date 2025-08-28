package com.example.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileUpdateRequest {

    @NotBlank
    private String fullName;

    private String phone;

    private String address;

    private String city;

    private String district;

    private String zipCode;


}
