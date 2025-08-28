package com.example.parcelservice.repository;

import com.example.parcelservice.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
    Optional<Parcel> findByTrackingCode(String trackingCode);

}
