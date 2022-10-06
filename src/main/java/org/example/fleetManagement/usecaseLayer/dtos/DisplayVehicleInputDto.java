package org.example.fleetManagement.usecaseLayer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DisplayVehicleInputDto {
    private String branchName;
    private Integer startTime;
    private Integer endTime;
}
