package org.example.fleetManagement.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.domainLayer.Branch;
import org.example.fleetManagement.domainLayer.BranchManager;
import org.example.fleetManagement.domainLayer.TimeSlot;
import org.example.fleetManagement.domainLayer.Vehicle;
import org.example.fleetManagement.usecaseLayer.GetAvailableVehicleByType;
import org.example.fleetManagement.usecaseLayer.dtos.GetAvailableVehicleByTypeInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.GetAvailableVehicleByTypeOutputDto;

@AllArgsConstructor
public class GetAvailableVehicleByTypeImpl implements GetAvailableVehicleByType {

    private BranchManager branchManager;

    @Override
    public GetAvailableVehicleByTypeOutputDto getAvailableVehicleByType(GetAvailableVehicleByTypeInputDto getAvailableVehicleByTypeInputDto) {
        Branch branch = branchManager.getBranchByName(getAvailableVehicleByTypeInputDto.getBranchName());
        Vehicle vehicle = branchManager.getAllAvailableVehicles(branch, new TimeSlot(getAvailableVehicleByTypeInputDto.getAvailabilityStartTime(), getAvailableVehicleByTypeInputDto.getAvailabilityEndTime()));
        return new GetAvailableVehicleByTypeOutputDto(vehicle.getId(), vehicle.getPrice().getAmount());
    }

}