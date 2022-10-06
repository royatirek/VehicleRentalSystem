package org.example.fleetManagement.domainLayer.strategies;

import org.example.fleetManagement.domainLayer.Vehicle;

import java.util.List;

public interface VehicleOrderingStrategy {
    List<Vehicle>  order(List<Vehicle> vehicles);
}
