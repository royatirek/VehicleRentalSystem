package org.example.fleetManagement.domainLayer.strategies.impl;

import org.example.fleetManagement.domainLayer.Price;
import org.example.fleetManagement.domainLayer.Vehicle;
import org.example.fleetManagement.domainLayer.VehicleType;
import org.example.fleetManagement.domainLayer.strategies.VehicleOrderingStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class VehicleOrderingByPriceStrategyTest {
    private VehicleOrderingStrategy vehicleOrderingStrategy = new VehicleOrderingByPriceStrategy();

    @Test
    void givenListOfVehicles_whenCalled_thenReturnInAscendingOrder() {
        List<Vehicle> vehicles = Arrays.asList(new Vehicle("V1", new Price(102), VehicleType.CAR), new Vehicle("V2", new Price(101), VehicleType.CAR));
        List<String> orderedVehiclesIds = vehicleOrderingStrategy.order(vehicles).stream().map(Vehicle::getId).collect(Collectors.toList());
        assertEquals(Arrays.asList("V2","V1"), orderedVehiclesIds);
    }
}