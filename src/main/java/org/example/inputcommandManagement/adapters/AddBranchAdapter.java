package org.example.inputcommandManagement.adapters;


import lombok.AllArgsConstructor;
import org.example.fleetManagement.usecaseLayer.AddBranch;
import org.example.fleetManagement.usecaseLayer.dtos.AddBranchInputDto;
import org.example.inputcommandManagement.executers.AddBranchCommandExecuter;

import java.util.List;

@AllArgsConstructor
public class AddBranchAdapter implements AddBranchCommandExecuter {
    private AddBranch addBranch;
    @Override
    public boolean addBranch(String branchName, List<String> vehicleTypes) {
        AddBranchInputDto addBranchInputDto = new AddBranchInputDto(branchName, vehicleTypes);
        return addBranch.createBranch(addBranchInputDto).getIsSuccess();
    }
}
