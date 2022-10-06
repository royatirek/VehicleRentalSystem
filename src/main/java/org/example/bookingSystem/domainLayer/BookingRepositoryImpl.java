package org.example.bookingSystem.domainLayer;

import java.util.LinkedList;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {
    private List<Booking> bookings = new LinkedList<>();
    @Override
    public void createBooking(Booking booking) {
        bookings.add(booking);
    }
}
