package com.example.trackingservice.mapper;

import com.example.trackingservice.dto.TrackingRecordRequest;
import com.example.trackingservice.dto.TrackingRecordResponse;
import com.example.trackingservice.model.TrackingRecord;

import java.time.LocalDateTime;

public class TrackingRecordMapper {

    public static TrackingRecord toEntity(TrackingRecordRequest request){
        return TrackingRecord.builder()
                .trackingCode(request.getTrackingCode())
                .location(request.getLocation())
                .status(request.getStatus())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static TrackingRecordResponse toResponse(TrackingRecord record){
        return TrackingRecordResponse.builder()
                .trackingCode(record.getTrackingCode())
                .location(record.getLocation())
                .status(record.getStatus())
                .timestamp(record.getTimestamp())
                .build();
    }

}
