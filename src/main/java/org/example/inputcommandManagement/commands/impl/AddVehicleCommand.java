package org.example.inputcommandManagement.commands.impl;

import org.example.inputcommandManagement.commands.Command;
import org.example.inputcommandManagement.executers.AddVehicleCommandExecuter;

public class AddVehicleCommand extends Command {

    private AddVehicleCommandExecuter addVehicleCommandExecuter;

    public AddVehicleCommand(AddVehicleCommandExecuter addVehicleCommandExecuter) {
        this.addVehicleCommandExecuter = addVehicleCommandExecuter;
    }

    @Override
    public void execute() {
        String branchName = commandArguments[1];
        String vehicleType = commandArguments[2];
        String vehicleId = commandArguments[3];
        Integer price = Integer.parseInt(commandArguments[4]);
        System.out.println(addVehicleCommandExecuter.addVehicle(branchName, vehicleType, vehicleId, price));
    }
}
