package org.example.bookingSystem.domainLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Booking {
    private final Vehicle vehicle;
    private BookedTimeSlots bookedTimeSlot;
    private LocalDateTime orderDate;
    private Integer total;
}
