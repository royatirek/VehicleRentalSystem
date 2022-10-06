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
    public Branch getBranchByName(String branchName) {
        return branchRepository.getBranchById(branchName);
    }

    @Override
    public List<Vehicle> getVehicles(Branch branch, TimeSlot timeSlot) {
        return vehicleOrderingStrategy.order(branch.getVehiclesForTimeSlot(timeSlot));
    }

    @Override
    public Vehicle getVehicle(Branch branch, VehicleType vehicleType, TimeSlot timeSlot) {
        Vehicle vehicle =  vehicleSelectionStrategy.getSelectedVehicle(
                branch.getVehiclesByTypeAndTimeSlot(timeSlot, vehicleType));
        return vehicle;
    }

    public void blockTimeSlot(Branch branch, Vehicle vehicle, TimeSlot timeSlot) {
        branch.makeVehicleNonAvailaible(vehicle, new NotAvailabilityTimeSlot(timeSlot.getStartTime(), timeSlot.getEndTime()));
    }

    public Vehicle getVehicle(Branch branch, String vehicleId) {
        return branch.getVehicle(vehicleId);
    }
}
