package org.example.bookingSystem.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.bookingSystem.domainLayer.Booking;
import org.example.bookingSystem.domainLayer.BookingManager;
import org.example.bookingSystem.usecaseLayer.BookVehicle;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleInputDto;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleOutputDto;
import org.example.fleetManagement.domainLayer.exceptions.NoVehicleFoundException;

@AllArgsConstructor
public class BookVehicleImpl implements BookVehicle {
    private BookingManager bookingManager;
    private static Integer  NO_VEHICLE_FOUND_PRICE = -1;

    @Override
    public BookVehicleOutputDto bookVehicle(BookVehicleInputDto bookVehicleInputDto) {
        try {
            Booking booking = bookingManager.createBooking(bookVehicleInputDto.getBranchName(), bookVehicleInputDto.getVehicleType(), bookVehicleInputDto.getBookedTimeSlots());
            return new BookVehicleOutputDto(booking.getTotal());

        } catch (NoVehicleFoundException exception) {
            return new BookVehicleOutputDto(NO_VEHICLE_FOUND_PRICE);
        }
    }
}
