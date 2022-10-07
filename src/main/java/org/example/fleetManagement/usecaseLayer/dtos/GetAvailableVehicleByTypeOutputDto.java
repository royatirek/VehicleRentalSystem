package org.example.fleetManagement.usecaseLayer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetAvailableVehicleByTypeOutputDto {
    private String vehicleId;
    private Integer pricePerHour;
}
