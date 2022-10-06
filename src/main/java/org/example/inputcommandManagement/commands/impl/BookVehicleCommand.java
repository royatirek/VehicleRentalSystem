package org.example.inputcommandManagement.commands.impl;

import org.example.bookingSystem.domainLayer.BookedTimeSlots;
import org.example.inputcommandManagement.commands.Command;
import org.example.inputcommandManagement.executers.BookVehicleCommandExecuter;


public class BookVehicleCommand extends Command {

    private BookVehicleCommandExecuter bookVehicleCommandExecuter;

    public BookVehicleCommand(BookVehicleCommandExecuter bookVehicleCommandExecuter) {
        this.bookVehicleCommandExecuter = bookVehicleCommandExecuter;
    }
    @Override
    public void execute() {
          System.out.println(bookVehicleCommandExecuter.bookVehicle(commandArguments));
    }
}
