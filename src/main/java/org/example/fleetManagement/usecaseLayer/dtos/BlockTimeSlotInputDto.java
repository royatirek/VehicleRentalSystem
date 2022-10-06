package org.example.fleetManagement.usecaseLayer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.fleetManagement.domainLayer.TimeSlot;

@AllArgsConstructor
@Getter
public class BlockTimeSlotInputDto {
    private String branchName;
    private String vehicleId;
    private Integer blockingStartTime;
    private Integer blockingEndTime;
}
