package org.example.fleetManagement.usecaseLayer;

import org.example.fleetManagement.usecaseLayer.dtos.AddVehicleInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.AddVehicleOutputDto;

public interface AddVehicle {
    AddVehicleOutputDto addVehicle(AddVehicleInputDto addVehicleInputDto);
}
