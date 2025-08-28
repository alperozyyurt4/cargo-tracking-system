package com.example.parcelservice.dto;

import com.example.parcelservice.model.ParcelStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParcelResponse {
    private Long id;

    private String trackingCode;

    private String senderEmail;
    private String receiverEmail;

    private String fromCity;
    private String fromDistrict;

    private String toCity;
    private String toDistrict;

    private Double weight;
    private String size;

    private ParcelStatus status;

    private boolean isPaid;

    private LocalDateTime createdAt;
    private LocalDateTime deliveryAt;
}
