package org.example.inputcommandManagement.commands.impl;

import lombok.AllArgsConstructor;
import org.example.inputcommandManagement.commands.Command;
import org.example.inputcommandManagement.executers.DisplayVehicleCommandExecuter;

import java.util.List;
import java.util.stream.Collectors;

public class DisplayVehicleCommand extends Command {

    private DisplayVehicleCommandExecuter displayVehicleCommandExecuter;

    public DisplayVehicleCommand(DisplayVehicleCommandExecuter displayVehicleCommandExecuter) {
        this.displayVehicleCommandExecuter = displayVehicleCommandExecuter;
    }
    @Override
    public void execute() {
        String branchName = commandArguments[1];
        Integer startTime = Integer.parseInt(commandArguments[2]);
        Integer endTime = Integer.parseInt(commandArguments[3]);
        List<String> vehiclesIds = displayVehicleCommandExecuter.displayDisplay(branchName, startTime, endTime);
        String vehicleIdsCommaSeperated = vehiclesIds.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(vehicleIdsCommaSeperated);
    }
}
