package org.example.fleetManagement.domainLayer;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.domainLayer.repositories.BranchRepository;
import org.example.fleetManagement.domainLayer.strategies.VehicleOrderingStrategy;
import org.example.fleetManagement.domainLayer.strategies.VehicleSelectionStrategy;

import java.util.List;

@AllArgsConstructor
public class BranchManagerImpl implements BranchManager {

    private BranchRepository branchRepository;
    private VehicleOrderingStrategy vehicleOrderingStrategy;

    private VehicleSelectionStrategy vehicleSelectionStrategy;
    @Override
    public boolean addBranch(Branch branch) {
        return branchRepository.addBranch(branch);
    }
    @Override
    public boolean addVehicle(Branch branch, Vehicle vehicle) {
        return branch.addVehicle(vehicle);
    }
    @Override
    public Branch getBranchByName(String id) {
        return branchRepository.getBranchById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles(Branch branch, TimeSlot timeSlot) {
        return vehicleOrderingStrategy.order(branch.getAllAvailableVehiclesForTimeSlot(timeSlot));
    }

    @Override
    public Vehicle getVehicle(Branch branch, VehicleType vehicleType, TimeSlot timeSlot) {
        Vehicle vehicle =  vehicleSelectionStrategy.getSelectedVehicle(branch.getAllAvailableVehiclesForVehicleTypeAndTimeSlot(timeSlot, vehicleType));
        branch.makeVehicleNonAvailaible(vehicle, new NotAvailabilityTimeSlot(timeSlot.getStartTime(), timeSlot.getEndTime()));
        return vehicle;
    }
}
