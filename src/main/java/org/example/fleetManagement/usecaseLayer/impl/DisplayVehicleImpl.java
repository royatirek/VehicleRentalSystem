package org.example.fleetManagement.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.domainLayer.Branch;
import org.example.fleetManagement.domainLayer.BranchManager;
import org.example.fleetManagement.usecaseLayer.DisplayVehicle;
import org.example.fleetManagement.usecaseLayer.dtos.DisplayVehicleInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.DisplayVehicleOutputDto;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DisplayVehicleImpl implements DisplayVehicle {
    private BranchManager branchManager;

    @Override
    public DisplayVehicleOutputDto displayVehicle(DisplayVehicleInputDto displayVehicleInputDto) {
        Branch branch = branchManager.getBranchByName(displayVehicleInputDto.getBranchName());
        List<String> vehicleIds = branchManager.getAllVehicles(branch)
                .stream()
                .map(vehicle -> vehicle.getId())
                .collect(Collectors.toList());
        return new DisplayVehicleOutputDto(vehicleIds);
    }
}
