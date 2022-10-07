package org.example.fleetManagement.domainLayer.strategies.impl;

import org.example.fleetManagement.domainLayer.Price;
import org.example.fleetManagement.domainLayer.Vehicle;
import org.example.fleetManagement.domainLayer.VehicleType;
import org.example.fleetManagement.domainLayer.exceptions.NoVehicleFoundException;
import org.example.fleetManagement.domainLayer.strategies.VehicleSelectionStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleLowestPriceSelectionStrategyTest {

    private VehicleSelectionStrategy vehicleSelectionStrategy = new VehicleLowestPriceSelectionStrategy();


    @Test
    void givenListOfVehicles_whenCalled_thenReturnLowestCostVehicle() {
        List<Vehicle> vehicles = Arrays.asList(new Vehicle("V1", new Price(102), VehicleType.CAR),
                new Vehicle("V2", new Price(101), VehicleType.CAR));
        Vehicle vehicle = vehicleSelectionStrategy.getSelectedVehicle(vehicles);
        assertEquals("V2", vehicle.getId());
    }


    @Test
    void givenEmptyListOfVehicles_whenCalled_thenThrowException() {
        Throwable throwable  = assertThrows(NoVehicleFoundException.class, () ->
                vehicleSelectionStrategy.getSelectedVehicle(new LinkedList<>()));
        assertEquals(NoVehicleFoundException.class, throwable.getClass());
    }

}