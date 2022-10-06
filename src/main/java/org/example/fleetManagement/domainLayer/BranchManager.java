package org.example.fleetManagement.domainLayer;

import java.util.List;

public interface BranchManager {
    boolean addBranch(Branch branch);

    boolean addVehicle(Branch branch, Vehicle vehicle);

    Branch getBranchByName(String id);

    List<Vehicle> getAllVehicles(Branch branch);

    Vehicle getAllAvailableVehicles(Branch branch, TimeSlot timeSlot);
}
