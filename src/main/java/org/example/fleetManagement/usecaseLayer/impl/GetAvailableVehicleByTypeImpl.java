package org.example.fleetManagement.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.domainLayer.*;
import org.example.fleetManagement.usecaseLayer.GetAvailableVehicleByType;
import org.example.fleetManagement.usecaseLayer.dtos.GetAvailableVehicleByTypeInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.GetAvailableVehicleByTypeOutputDto;

@AllArgsConstructor
public class GetAvailableVehicleByTypeImpl implements GetAvailableVehicleByType {

    private BranchManager branchManager;

    @Override
    public GetAvailableVehicleByTypeOutputDto getAvailableVehicleByType(GetAvailableVehicleByTypeInputDto getAvailableVehicleByTypeInputDto) {
        Branch branch = branchManager.getBranchByName(getAvailableVehicleByTypeInputDto.getBranchName());
        Vehicle vehicle = branchManager.getVehicle(branch, VehicleType.valueOf(getAvailableVehicleByTypeInputDto.getVehicleType()), new TimeSlot(getAvailableVehicleByTypeInputDto.getAvailabilityStartTime(), getAvailableVehicleByTypeInputDto.getAvailabilityEndTime()));
        return new GetAvailableVehicleByTypeOutputDto(vehicle.getId(), vehicle.getPrice().getAmountPerHour());
    }

}