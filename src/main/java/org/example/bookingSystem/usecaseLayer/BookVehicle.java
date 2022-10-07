package org.example.bookingSystem.usecaseLayer;

import org.example.bookingSystem.usecaseLayer.dto.BookVehicleInputDto;
import org.example.bookingSystem.usecaseLayer.dto.BookVehicleOutputDto;

public interface BookVehicle {
    BookVehicleOutputDto bookVehicle(BookVehicleInputDto bookVehicleInputDto);
}
