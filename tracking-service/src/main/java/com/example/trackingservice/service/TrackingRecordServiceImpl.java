package com.example.trackingservice.service;

import com.example.trackingservice.dto.TrackingRecordRequest;
import com.example.trackingservice.dto.TrackingRecordResponse;
import com.example.trackingservice.mapper.TrackingRecordMapper;
import com.example.trackingservice.model.TrackingRecord;
import com.example.trackingservice.repository.TrackingRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackingRecordServiceImpl implements TrackingRecordService{

    private final TrackingRecordRepository trackingRecordRepository;
    @Override
    public TrackingRecordResponse addTrackingRecord(TrackingRecordRequest request) {
        TrackingRecord record = TrackingRecordMapper.toEntity(request);
        trackingRecordRepository.save(record);
        return TrackingRecordMapper.toResponse(record);
    }

    @Override
    public List<TrackingRecordResponse> getTrackingHistory(String trackingCode) {
        List<TrackingRecord> records = trackingRecordRepository.findAllByTrackingCodeOrderByTimestampDesc(trackingCode);

        return records.stream()
                .map(TrackingRecordMapper::toResponse)
                .collect(Collectors.toList());
    }
}
