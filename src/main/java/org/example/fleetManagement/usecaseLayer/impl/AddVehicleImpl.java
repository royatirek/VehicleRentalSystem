package org.example.fleetManagement.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.domainLayer.*;
import org.example.fleetManagement.domainLayer.BranchManager;
import org.example.fleetManagement.domainLayer.exceptions.VehicleTypeNotSupportedException;
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
        try {
            branchManager.addVehicle(branch, vehicle);
            return new AddVehicleOutputDto(true);
        } catch (VehicleTypeNotSupportedException exception) {
            return new AddVehicleOutputDto(false);
        }
    }
}
