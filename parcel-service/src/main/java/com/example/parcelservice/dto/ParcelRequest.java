package com.example.parcelservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParcelRequest {
    @NotBlank
    @Email
    private String senderEmail;

    @NotBlank
    @Email
    private String receiverEmail;

    @NotBlank
    private String fromCity;

    @NotBlank
    private String fromDistrict;

    @NotBlank
    private String toCity;

    @NotBlank
    private String toDistrict;

    @NotNull
    private Double weight;

    @NotBlank
    private String size; // S, M, L

}
