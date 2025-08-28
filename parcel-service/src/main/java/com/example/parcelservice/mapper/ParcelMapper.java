package com.example.parcelservice.mapper;

import com.example.parcelservice.dto.ParcelRequest;
import com.example.parcelservice.dto.ParcelResponse;
import com.example.parcelservice.model.Parcel;
import com.example.parcelservice.model.ParcelStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParcelMapper {

    public static Parcel toEntity(ParcelRequest request) {
        return Parcel.builder()
                .trackingCode(generateTrackingCode())
                .senderEmail(request.getSenderEmail())
                .receiverEmail(request.getReceiverEmail())
                .fromCity(request.getFromCity())
                .fromDistrict(request.getFromDistrict())
                .toCity(request.getToCity())
                .toDistrict(request.getToDistrict())
                .weight(request.getWeight())
                .size(request.getSize())
                .status(ParcelStatus.CREATED)
                .isPaid(false)
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static ParcelResponse toResponse(Parcel parcel) {
        return ParcelResponse.builder()
                .id(parcel.getId())
                .trackingCode(parcel.getTrackingCode())
                .senderEmail(parcel.getSenderEmail())
                .receiverEmail(parcel.getReceiverEmail())
                .fromCity(parcel.getFromCity())
                .fromDistrict(parcel.getFromDistrict())
                .toCity(parcel.getToCity())
                .toDistrict(parcel.getToDistrict())
                .weight(parcel.getWeight())
                .size(parcel.getSize())
                .status(parcel.getStatus())
                .isPaid(parcel.isPaid())
                .createdAt(parcel.getCreatedAt())
                .deliveryAt(parcel.getDeliveryAt())
                .build();
    }

    private static String generateTrackingCode() {
        return UUID.randomUUID().toString().substring(0, 10).toUpperCase();
    }
}
