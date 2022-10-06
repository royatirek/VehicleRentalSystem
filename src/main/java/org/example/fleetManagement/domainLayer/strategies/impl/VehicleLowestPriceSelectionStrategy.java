package org.example.fleetManagement.domainLayer.strategies.impl;

import org.example.fleetManagement.domainLayer.Vehicle;
import org.example.fleetManagement.domainLayer.exceptions.NoVehicleFound;
import org.example.fleetManagement.domainLayer.strategies.VehicleSelectionStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VehicleLowestPriceSelectionStrategy implements VehicleSelectionStrategy {
    @Override
    public Vehicle getSelectedVehicle(List<Vehicle> vehicles) {
        Optional<Vehicle> vehicle =  vehicles.stream().sorted(Comparator.comparing(Vehicle::getPrice)).findFirst();
        if(vehicle.isPresent())
            return vehicle.get();
        throw new NoVehicleFound("No vehicle found based on price");
    }
}
