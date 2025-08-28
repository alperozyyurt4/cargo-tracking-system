package com.example.parcelservice.service;

import com.example.parcelservice.dto.ParcelRequest;
import com.example.parcelservice.dto.ParcelResponse;
import com.example.parcelservice.model.ParcelStatus;

public interface ParcelService {
    ParcelResponse createParcel(ParcelRequest request);
    ParcelResponse getByTrackingCode(String trackingCode);
    ParcelResponse updateStatus(String trackingCode, ParcelStatus status);



}
