package org.example.bookingSystem.domainLayer;

public interface BookingManager {
    Booking createBooking(String branchName, String vehicle, BookedTimeSlots bookedTimeSlots);
}
