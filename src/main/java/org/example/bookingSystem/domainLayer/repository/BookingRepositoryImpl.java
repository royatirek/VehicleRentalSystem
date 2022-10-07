package org.example.bookingSystem.domainLayer.repository;

import org.example.bookingSystem.domainLayer.Booking;

import java.util.LinkedList;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {
    private List<Booking> bookings = new LinkedList<>();
    @Override
    public void createBooking(Booking booking) {
        bookings.add(booking);
    }
}
