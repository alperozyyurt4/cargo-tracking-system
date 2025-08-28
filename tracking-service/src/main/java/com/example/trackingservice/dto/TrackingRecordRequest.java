package com.example.trackingservice.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingRecordRequest {

    @NotBlank
    private String trackingCode;

    @NotBlank
    private String location;

    @NotBlank
    private String status;
}
