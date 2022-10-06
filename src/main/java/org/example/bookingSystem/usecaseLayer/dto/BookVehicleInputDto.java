package org.example.bookingSystem.usecaseLayer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.bookingSystem.domainLayer.BookedTimeSlots;

@AllArgsConstructor
@Getter
public class BookVehicleInputDto {
    private String branchName;
    private String vehicleType;
    private BookedTimeSlots bookedTimeSlots;
}
