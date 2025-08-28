package com.example.parcelservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "parcels")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parcel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String trackingCode;

    @Column(nullable = false)
    private String senderEmail;

    @Column(nullable = false)
    private String receiverEmail;

    private String fromCity;
    private String fromDistrict;

    private String toCity;
    private String toDistrict;

    private Double weight; // kg
    private String size;   // S, M, L

    @Enumerated(EnumType.STRING)
    private ParcelStatus status;

    private boolean isPaid;

    private LocalDateTime createdAt;
    private LocalDateTime deliveryAt;




}
