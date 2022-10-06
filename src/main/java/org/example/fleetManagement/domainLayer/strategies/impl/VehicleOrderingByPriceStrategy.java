package org.example.fleetManagement.domainLayer.strategies.impl;

import org.example.fleetManagement.domainLayer.Vehicle;
import org.example.fleetManagement.domainLayer.strategies.VehicleOrderingStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleOrderingByPriceStrategy implements VehicleOrderingStrategy {
    @Override
    public List<Vehicle> order(List<Vehicle> vehicles) {
        return vehicles.stream().sorted(Comparator.comparing(Vehicle::getPrice)).collect(Collectors.toList());
    }
}
