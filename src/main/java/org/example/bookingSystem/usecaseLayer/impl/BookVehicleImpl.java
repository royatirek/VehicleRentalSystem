package org.example.bookingSystem.usecaseLayer.impl;

import lombok.AllArgsConstructor;
import org.example.bookingSystem.domainLayer.Booking;
import org.example.bookingSystem.domainLayer.BookingManager;
import org.example.bookingSystem.domainLayer.BookingManagerImpl;
import org.example.bookingSystem.usecaseLayer.BookVehicle;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleInputDto;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleOutputDto;

@AllArgsConstructor
public class BookVehicleImpl implements BookVehicle {
    private BookingManager bookingManager;

    @Override
    public BookVehicleOutputDto bookVehicle(BookVehicleInputDto bookVehicleInputDto) {
        Booking booking = bookingManager.createBooking(bookVehicleInputDto.getBranchName(),bookVehicleInputDto.getVehicleType(), bookVehicleInputDto.getBookedTimeSlots());
        return new BookVehicleOutputDto(booking.getTotal());
    }
}
