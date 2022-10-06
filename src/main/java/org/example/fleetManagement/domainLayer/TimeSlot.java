package org.example.fleetManagement.domainLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TimeSlot {
    private Integer startTime;
    private Integer endTime;
}
