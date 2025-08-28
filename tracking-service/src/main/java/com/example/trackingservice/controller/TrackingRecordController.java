package com.example.trackingservice.controller;

import com.example.trackingservice.dto.TrackingRecordRequest;
import com.example.trackingservice.dto.TrackingRecordResponse;
import com.example.trackingservice.service.TrackingRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trackings")
@RequiredArgsConstructor
public class TrackingRecordController {

    private final TrackingRecordService trackingRecordService;

    @PostMapping
    public ResponseEntity<TrackingRecordResponse> addTracking(@RequestBody @Valid TrackingRecordRequest request){
        TrackingRecordResponse response = trackingRecordService.addTrackingRecord(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{trackingCode}")
    public ResponseEntity<List<TrackingRecordResponse>> getTrackingHistory(@PathVariable String trackingCode){
        List<TrackingRecordResponse> records = trackingRecordService.getTrackingHistory(trackingCode);
        return ResponseEntity.ok(records);
    }
}
