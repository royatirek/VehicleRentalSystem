package org.example.bookingSystem.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.bookingSystem.domainLayer.Booking;
import org.example.bookingSystem.domainLayer.BookingManager;
import org.example.bookingSystem.usecaseLayer.BookVehicle;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleInputDto;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleOutputDto;
import org.example.fleetManagement.domainLayer.exceptions.NoVehicleFound;

@AllArgsConstructor
public class BookVehicleImpl implements BookVehicle {
    private BookingManager bookingManager;

    @Override
    public BookVehicleOutputDto bookVehicle(BookVehicleInputDto bookVehicleInputDto) {
        try {
            Booking booking = bookingManager.createBooking(bookVehicleInputDto.getBranchName(), bookVehicleInputDto.getVehicleType(), bookVehicleInputDto.getBookedTimeSlots());
            return new BookVehicleOutputDto(booking.getTotal());

        } catch (NoVehicleFound exception) {
            return new BookVehicleOutputDto(-1);
        }
    }
}
