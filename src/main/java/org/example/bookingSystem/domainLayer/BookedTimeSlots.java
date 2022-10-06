package org.example.bookingSystem.domainLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookedTimeSlots {
    private Integer startTime;
    private Integer endTime;
}
