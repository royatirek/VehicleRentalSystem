package org.example.inputcommandManagement.adapters;


import lombok.AllArgsConstructor;
import org.example.fleetManagement.usecaseLayer.AddBranch;
import org.example.fleetManagement.usecaseLayer.dtos.AddBranchInputDto;
import org.example.inputcommandManagement.executers.AddBranchCommandExecuter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AddBranchAdapter implements AddBranchCommandExecuter {
    private AddBranch addBranch;
    @Override
    public boolean addBranch(String[] commandArguments) {
        String branchName = commandArguments[1].trim();
        List<String> vehicleTypes = Arrays.stream(commandArguments[2].trim().split(",")).collect(Collectors.toList());
        AddBranchInputDto addBranchInputDto = new AddBranchInputDto(branchName, vehicleTypes);
        return addBranch.createBranch(addBranchInputDto).getIsSuccess();
    }
}
