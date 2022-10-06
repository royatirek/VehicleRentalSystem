package org.example.fleetManagement.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.domainLayer.Branch;
import org.example.fleetManagement.domainLayer.BranchManager;
import org.example.fleetManagement.domainLayer.TimeSlot;
import org.example.fleetManagement.domainLayer.Vehicle;
import org.example.fleetManagement.usecaseLayer.BlockTimeSlot;
import org.example.fleetManagement.usecaseLayer.dtos.BlockTimeSlotInputDto;

@AllArgsConstructor
public class BlockTimeSlotImpl implements BlockTimeSlot {
    private BranchManager branchManager;

    @Override
    public void blockTimeSlot(BlockTimeSlotInputDto blockTimeSlotInputDto) {
        Branch branch = branchManager.getBranchByName(blockTimeSlotInputDto.getBranchName());
        Vehicle vehicle = branchManager.getVehicle(branch, blockTimeSlotInputDto.getVehicleId());
        branchManager.blockTimeSlot(branch, vehicle, new TimeSlot(blockTimeSlotInputDto.getBlockingStartTime(), blockTimeSlotInputDto.getBlockingEndTime()));
    }
}
