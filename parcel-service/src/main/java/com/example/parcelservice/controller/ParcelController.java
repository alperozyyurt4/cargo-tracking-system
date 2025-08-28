package com.example.parcelservice.controller;

import com.example.parcelservice.dto.ParcelRequest;
import com.example.parcelservice.dto.ParcelResponse;
import com.example.parcelservice.model.ParcelStatus;
import com.example.parcelservice.service.ParcelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcels")
@RequiredArgsConstructor
public class ParcelController {

    private final ParcelService parcelService;

    @PostMapping
    public ResponseEntity<ParcelResponse> createParcel(@RequestBody @Valid ParcelRequest request){
        ParcelResponse response = parcelService.createParcel(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{trackingCode}")
    public ResponseEntity<ParcelResponse> getParcelByTrackingCode(@PathVariable String trackingCode){
        ParcelResponse response = parcelService.getByTrackingCode(trackingCode);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{trackingCode}/status")
    public ResponseEntity<ParcelResponse> updateStatus(
            @PathVariable String trackingCode,
            @RequestParam ParcelStatus status
            ){
        ParcelResponse response = parcelService.updateStatus(trackingCode,status);
        return ResponseEntity.ok(response);
    }
}
