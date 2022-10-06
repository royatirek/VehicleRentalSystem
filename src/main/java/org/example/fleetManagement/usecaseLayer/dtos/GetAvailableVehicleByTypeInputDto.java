package org.example.fleetManagement.usecaseLayer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.bookingSystem.domainLayer.BookedTimeSlots;

@AllArgsConstructor
@Getter
public class GetAvailableVehicleByTypeInputDto {
    private String branchName;
    private String vehicle;
    private Integer availabilityStartTime;
    private Integer availabilityEndTime;
}
