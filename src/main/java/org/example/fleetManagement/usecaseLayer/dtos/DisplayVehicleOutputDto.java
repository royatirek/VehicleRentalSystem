package org.example.fleetManagement.usecaseLayer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DisplayVehicleOutputDto {
    private List<String> vehicleIds;
}
