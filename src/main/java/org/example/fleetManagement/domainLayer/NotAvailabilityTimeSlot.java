package org.example.fleetManagement.domainLayer;


import lombok.Getter;

public class NotAvailabilityTimeSlot extends TimeSlot {
    public NotAvailabilityTimeSlot(Integer startTime, Integer endTime) {
        super(startTime, endTime);
    }
}
