package org.example.inputcommandManagement.adapters;

import lombok.AllArgsConstructor;
import org.example.bookingSystem.domainLayer.BookedTimeSlots;
import org.example.bookingSystem.usecaseLayer.BookVehicle;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleInputDto;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleOutputDto;
import org.example.inputcommandManagement.executers.BookVehicleCommandExecuter;

@AllArgsConstructor
public class BookVehicleAdapter implements BookVehicleCommandExecuter {
    private BookVehicle bookVehicle;
    @Override
    public Integer bookVehicle(String branchName, String vehicleType, BookedTimeSlots bookedTimeSlots) {
        BookVehicleOutputDto bookVehicleOutputDto =  bookVehicle.bookVehicle(new BookVehicleInputDto(branchName, vehicleType, bookedTimeSlots));
        return bookVehicleOutputDto.getPrice();
    }
}
