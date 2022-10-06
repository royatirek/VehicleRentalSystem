package org.example.fleetManagement.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.domainLayer.Branch;
import org.example.fleetManagement.domainLayer.BranchManager;
import org.example.fleetManagement.domainLayer.VehicleType;
import org.example.fleetManagement.usecaseLayer.AddBranch;
import org.example.fleetManagement.usecaseLayer.dtos.AddBranchInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.AddBranchOutputDto;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AddBranchImpl implements AddBranch {
    private BranchManager branchManager;
    @Override
    public AddBranchOutputDto createBranch(AddBranchInputDto addBranchInputDto) {
        List<VehicleType> vehicleTypes = addBranchInputDto.getVehicleTypes().stream()
                .map(vehicleType -> VehicleType.valueOf(vehicleType))
                .collect(Collectors.toList());
        Branch branch = new Branch(addBranchInputDto.getBranchName(), new LinkedList<>(), vehicleTypes);
        return new AddBranchOutputDto(branchManager.addBranch(branch));
    }
}
