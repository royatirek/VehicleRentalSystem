package org.example.inputcommandManagement.commands.impl;

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
        List<String> vehiclesIds = displayVehicleCommandExecuter.displayDisplay(commandArguments);
        String vehicleIdsCommaSeperated = vehiclesIds.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(vehicleIdsCommaSeperated);
    }
}
