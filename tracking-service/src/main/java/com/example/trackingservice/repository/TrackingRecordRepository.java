package com.example.trackingservice.repository;

import com.example.trackingservice.model.TrackingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingRecordRepository extends JpaRepository<TrackingRecord, Long> {
    List<TrackingRecord> findAllByTrackingCodeOrderByTimestampDesc(String trackingCode);
}
