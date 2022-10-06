package org.example.inputcommandManagement.commands.impl;

import lombok.AllArgsConstructor;
import org.example.inputcommandManagement.commands.Command;
import org.example.inputcommandManagement.executers.AddBranchCommandExecuter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AddBranchCommand extends Command {
    private AddBranchCommandExecuter addBranchCommandExecuter;


    public void execute() {
        String branchName = commandArguments[1].trim();
        List<String> vehicleTypes = Arrays.stream(commandArguments[2].trim().split(",")).collect(Collectors.toList());
        System.out.println(addBranchCommandExecuter.addBranch(branchName, vehicleTypes));
    }


}
