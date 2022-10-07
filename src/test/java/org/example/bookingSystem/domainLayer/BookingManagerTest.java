package org.example.bookingSystem.domainLayer;

import org.example.bookingSystem.domainLayer.repository.BookingRepository;
import org.example.fleetManagement.domainLayer.VehicleType;
import org.example.fleetManagement.usecaseLayer.BlockTimeSlot;
import org.example.fleetManagement.usecaseLayer.GetAvailableVehicleByType;
import org.example.fleetManagement.usecaseLayer.dtos.BlockTimeSlotInputDto;
import org.example.fleetManagement.usecaseLayer.dtos.GetAvailableVehicleByTypeOutputDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class BookingManagerTest {
    private GetAvailableVehicleByType getAvailableVehicleByType = mock(GetAvailableVehicleByType.class);
    private BookingRepository bookingRepository = mock(BookingRepository.class);
    private BlockTimeSlot blockTimeSlot = mock(BlockTimeSlot.class);
    private BookingManager bookingManager = new BookingManagerImpl(getAvailableVehicleByType, bookingRepository, blockTimeSlot);

    @Test
    void givenAvailableVehicle_whenBookingIsCreated_thenTimeSlotShouldBeBlocked(){
        when(getAvailableVehicleByType.getAvailableVehicleByType(any())).thenReturn(new GetAvailableVehicleByTypeOutputDto("V1", 100));
        ArgumentCaptor<BlockTimeSlotInputDto> blockTimeSlotInputDtoArgumentCaptor = ArgumentCaptor.forClass(BlockTimeSlotInputDto.class);
        bookingManager.createBooking("B1", VehicleType.VAN.toString(), new BookedTimeSlots(1, 2));
        verify(blockTimeSlot, times(1)).blockTimeSlot(blockTimeSlotInputDtoArgumentCaptor.capture());
        assertEquals(1, (int)blockTimeSlotInputDtoArgumentCaptor.getValue().getBlockingStartTime());
        assertEquals(2, (int)blockTimeSlotInputDtoArgumentCaptor.getValue().getBlockingEndTime());
    }

    @Test
    void givenAvailableVehicle_whenBookingIsCreated_thenItShouldBePersisted(){
        when(getAvailableVehicleByType.getAvailableVehicleByType(any())).thenReturn(new GetAvailableVehicleByTypeOutputDto("V1", 100));
        ArgumentCaptor<Booking> bookingArgumentCaptor = ArgumentCaptor.forClass(Booking.class);
        bookingManager.createBooking("B1", VehicleType.VAN.toString(), new BookedTimeSlots(1, 2));
        verify(bookingRepository, times(1)).createBooking(bookingArgumentCaptor.capture());
        assertEquals("V1", bookingArgumentCaptor.getValue().getVehicle().getId());
    }

    @Test
    void givenAvailableVehicle_whenBookingIsCreated_thenRateBePerHourMultipliedByHoursRented(){
        when(getAvailableVehicleByType.getAvailableVehicleByType(any())).thenReturn(new GetAvailableVehicleByTypeOutputDto("V1", 100));
        ArgumentCaptor<Booking> bookingArgumentCaptor = ArgumentCaptor.forClass(Booking.class);
        Booking booking = bookingManager.createBooking("B1", VehicleType.VAN.toString(), new BookedTimeSlots(1, 6));
        assertEquals(500, (int) booking.getTotal());
    }
}