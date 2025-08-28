package com.example.trackingservice.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingRecordResponse {

    private String trackingCode;
    private String location;
    private String status;
    private LocalDateTime timestamp;
}
