package org.example.inputcommandManagement.executers;

import org.example.fleetManagement.domainLayer.VehicleType;

public interface AddVehicleCommandExecuter {
    boolean addVehicle(String branchName, String vehicleType, String vehicleId, Integer price);
}
