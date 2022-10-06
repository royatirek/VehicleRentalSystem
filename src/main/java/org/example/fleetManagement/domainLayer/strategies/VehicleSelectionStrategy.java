package org.example.fleetManagement.domainLayer.strategies;

import org.example.fleetManagement.domainLayer.Vehicle;

import java.util.List;

public interface VehicleSelectionStrategy {
    Vehicle getSelectedVehicle(List<Vehicle> vehicles);
}
