package com.example.parcelservice.dto;

import com.example.parcelservice.model.ParcelStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParcelStatusUpdateRequest {
    @NotNull
    private ParcelStatus status;

}
