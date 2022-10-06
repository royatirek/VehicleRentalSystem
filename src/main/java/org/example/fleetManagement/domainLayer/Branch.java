package org.example.fleetManagement.domainLayer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Branch {
    private final String branchName;
    private List<Vehicle> vehicles;

    private final List<VehicleType> possibleVehicleTypes;

    public Branch(String branchName, List<Vehicle> vehicles, List<VehicleType> possibleVehicleTypes) {
        this.branchName = branchName;
        this.vehicles = vehicles;
        this.possibleVehicleTypes = Collections.unmodifiableList(possibleVehicleTypes);
    }

    boolean addVehicle(Vehicle vehicle) {
        return vehicles.add(vehicle);
    }

    void makeVehicleNonAvailaible(Vehicle vehicle, NotAvailabilityTimeSlot notAvailabilityTimeSlots){
        vehicle.makeItUnAvailable(notAvailabilityTimeSlots);
    }

    Vehicle getVehicleId(String vehicleId) {
       for(Vehicle vehicle : vehicles) {
           if(vehicle.getId().equals(vehicleId))
               return vehicle;
       }
       return null;
    }

    List<Vehicle> getAllAvailableVehicles(TimeSlot timeSlotToUnavailable) {
        List<Vehicle> listOfAvailableVehicles = new LinkedList<>();
        for (Vehicle vehicle : vehicles) {
            for (TimeSlot timeSlot : vehicle.getNotAvailabilities()) {
                if (timeSlotToUnavailable.getStartTime() < timeSlot.getEndTime() && timeSlotToUnavailable.getStartTime() > timeSlot.getEndTime())
                    continue;
            }
            listOfAvailableVehicles.add(vehicle);
        }
        return listOfAvailableVehicles;
    }

    List<Vehicle> getVehicles() {
        return vehicles;
    }

    public String getBranchName() {
        return branchName;
    }
}
