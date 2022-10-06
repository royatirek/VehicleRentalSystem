package org.example.inputcommandManagement.executers;

import org.example.bookingSystem.domainLayer.BookedTimeSlots;

public interface BookVehicleCommandExecuter {
    Integer bookVehicle(String branchName, String vehicleType, BookedTimeSlots bookedTimeSlots);
}
