package org.example.inputcommandManagement.executers;

import org.example.fleetManagement.domainLayer.VehicleType;

public interface AddVehicleCommandExecuter {
    boolean addVehicle(String[] commandArguments);
}
