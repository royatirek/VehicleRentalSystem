package org.example.bookingSystem.usecaseLayer;

import org.example.bookingSystem.usecaseLayer.dto.BookVehicleInputDto;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleOutputDto;

public interface BookVehicle {
    public BookVehicleOutputDto bookVehicle(BookVehicleInputDto bookVehicleInputDto);
}
