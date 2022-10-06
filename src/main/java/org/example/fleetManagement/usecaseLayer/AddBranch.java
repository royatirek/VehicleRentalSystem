package org.example.fleetManagement.usecaseLayer;

import org.example.fleetManagement.usecaseLayer.dtos.AddBranchInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.AddBranchOutputDto;

public interface AddBranch {
    AddBranchOutputDto createBranch(AddBranchInputDto addBranchInputDto);
}
