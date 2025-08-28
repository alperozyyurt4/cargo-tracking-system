package com.example.trackingservice.service;

import com.example.trackingservice.dto.TrackingRecordRequest;
import com.example.trackingservice.dto.TrackingRecordResponse;

import java.util.List;

public interface TrackingRecordService {
    TrackingRecordResponse addTrackingRecord(TrackingRecordRequest request);
    List<TrackingRecordResponse> getTrackingHistory(String trackingCode);
}
