package org.example.fleetManagement.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.domainLayer.*;
import org.example.fleetManagement.domainLayer.BranchManager;
import org.example.fleetManagement.usecaseLayer.AddVehicle;
import org.example.fleetManagement.usecaseLayer.dtos.AddVehicleInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.AddVehicleOutputDto;

@AllArgsConstructor
public class AddVehicleImpl implements AddVehicle {
    private BranchManager branchManager;
    @Override
    public AddVehicleOutputDto addVehicle(AddVehicleInputDto addVehicleInputDto) {
        Branch branch = branchManager.getBranchByName(addVehicleInputDto.getBranchName());
        Vehicle vehicle = new Vehicle(addVehicleInputDto.getVehicleId(),
                new Price(addVehicleInputDto.getPrice()),
                VehicleType.valueOf(addVehicleInputDto.getVehicleType()));
        return new AddVehicleOutputDto(branchManager.addVehicle(branch, vehicle));
    }
}
