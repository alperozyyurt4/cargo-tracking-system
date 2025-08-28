package com.example.parcelservice.service;

import com.example.parcelservice.dto.ParcelRequest;
import com.example.parcelservice.dto.ParcelResponse;
import com.example.parcelservice.mapper.ParcelMapper;
import com.example.parcelservice.model.Parcel;
import com.example.parcelservice.model.ParcelStatus;
import com.example.parcelservice.repository.ParcelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService{


    private final ParcelRepository parcelRepository;

    @Override
    @Transactional
    public ParcelResponse createParcel(ParcelRequest request) {
        Parcel parcel = ParcelMapper.toEntity(request);
        parcelRepository.save(parcel);
        return ParcelMapper.toResponse(parcel);

    }

    @Override
    public ParcelResponse getByTrackingCode(String trackingCode) {
        Parcel parcel = parcelRepository.findByTrackingCode(trackingCode)
                .orElseThrow(() -> new RuntimeException("Kargo bulunamadı: " + trackingCode));
        return ParcelMapper.toResponse(parcel);
    }

    @Override
    public ParcelResponse updateStatus(String trackingCode, ParcelStatus status) {
        Parcel parcel = parcelRepository.findByTrackingCode(trackingCode)
                .orElseThrow(() -> new RuntimeException("Kargo bulunamadı: " + trackingCode));

        parcel.setStatus(status);
        if (status == ParcelStatus.DELIVERED){
            parcel.setDeliveryAt(LocalDateTime.now());
        }
        parcelRepository.save(parcel);
        return ParcelMapper.toResponse(parcel);
    }
}
