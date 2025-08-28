package com.example.authservice.dto;

import com.example.authservice.model.Role;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private String email;
    private String fullName;
    private Role role;
}
