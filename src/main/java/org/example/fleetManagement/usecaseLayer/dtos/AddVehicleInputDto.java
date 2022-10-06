package org.example.fleetManagement.usecaseLayer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddVehicleInputDto {
    private String branchName;
    private String vehicleType;
    private String vehicleId;
    private Integer price;
}
