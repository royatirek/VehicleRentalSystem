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
        String branchName = commandArguments[1];
        String vehicleType = commandArguments[2];
        BookedTimeSlots bookedTimeSlots = new BookedTimeSlots(Integer.parseInt(commandArguments[3]), Integer.parseInt(commandArguments[4]));
        System.out.println(bookVehicleCommandExecuter.bookVehicle(branchName, vehicleType, bookedTimeSlots));
    }
}
