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
        System.out.println(addVehicleCommandExecuter.addVehicle(commandArguments));
    }
}
