package org.example.bookingSystem.domainLayer.repository;

import org.example.bookingSystem.domainLayer.Booking;

public interface BookingRepository {
    void createBooking(Booking booking);
}
