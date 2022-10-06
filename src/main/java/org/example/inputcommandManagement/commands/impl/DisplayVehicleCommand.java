package org.example.inputcommandManagement.commands.impl;

import lombok.AllArgsConstructor;
import org.example.inputcommandManagement.commands.Command;
import org.example.inputcommandManagement.executers.DisplayVehicleCommandExecuter;

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
        System.out.println(displayVehicleCommandExecuter.displayDisplay(branchName, startTime, endTime));
    }
}
