package org.example.fleetManagement.usecaseLayer;

import org.example.fleetManagement.usecaseLayer.dtos.DisplayVehicleInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.DisplayVehicleOutputDto;

public interface DisplayVehicle {
    DisplayVehicleOutputDto displayVehicle(DisplayVehicleInputDto displayVehicleInputDto);
}
