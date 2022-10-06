package org.example.bookingSystem.domainLayer;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.usecaseLayer.BlockTimeSlot;
import org.example.fleetManagement.usecaseLayer.dtos.BlockTimeSlotInputDto;
import org.example.fleetManagement.usecaseLayer.GetAvailableVehicleByType;
import org.example.fleetManagement.usecaseLayer.dtos.GetAvailableVehicleByTypeInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.GetAvailableVehicleByTypeOutputDto;

import java.time.LocalDateTime;

@AllArgsConstructor
public class BookingManagerImpl implements BookingManager {

    private GetAvailableVehicleByType getAvailableVehicleByType;
    private BookingRepository bookingRepository;

    private BlockTimeSlot blockTimeSlot;
    @Override
    public Booking createBooking(String branchName, String vehicleType, BookedTimeSlots bookedTimeSlots) {
        GetAvailableVehicleByTypeInputDto getAvailableVehicleByTypeInputDto = new GetAvailableVehicleByTypeInputDto(branchName, vehicleType, bookedTimeSlots.getStartTime(), bookedTimeSlots.getEndTime());
        GetAvailableVehicleByTypeOutputDto getAvailableVehicleByTypeOutputDto =  getAvailableVehicleByType.getAvailableVehicleByType(getAvailableVehicleByTypeInputDto);
        Vehicle vehicle = new Vehicle(getAvailableVehicleByTypeOutputDto.getVehicleId());
        Booking booking = new Booking(vehicle, bookedTimeSlots, LocalDateTime.now(),getAvailableVehicleByTypeOutputDto.getPrice());
        bookingRepository.createBooking(booking);
        blockTimeSlot(new BlockTimeSlotInputDto(branchName, getAvailableVehicleByTypeOutputDto.getVehicleId(), bookedTimeSlots.getStartTime(), bookedTimeSlots.getEndTime()));
        return booking;
    }

    private void blockTimeSlot(BlockTimeSlotInputDto blockTimeSlotInputDto) {
        blockTimeSlot.blockTimeSlot(blockTimeSlotInputDto);
    }
}
