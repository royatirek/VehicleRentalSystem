package org.example.fleetManagement.domainLayer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        if(!possibleVehicleTypes.contains(vehicle.getVehicleType()))
            return false;
        return vehicles.add(vehicle);
    }

    void makeVehicleNonAvailaible(Vehicle vehicle, NotAvailabilityTimeSlot notAvailabilityTimeSlots){
        vehicle.makeItUnAvailable(notAvailabilityTimeSlots);
    }


    List<Vehicle> getAllAvailableVehiclesForVehicleTypeAndTimeSlot(TimeSlot timeSlotToUnavailable, VehicleType vehicleType) {
        List<Vehicle> vehiclesForRequiredType = vehicles.stream()
                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
        return getAllAvailableVehiclesForTimeSlot(timeSlotToUnavailable, vehiclesForRequiredType);
    }

    private List<Vehicle> getAllAvailableVehiclesForTimeSlot(TimeSlot timeSlotToUnavailable, List<Vehicle> vehicles) {
        List<Vehicle> listOfAvailableVehicles = new LinkedList<>();
        for (Vehicle vehicle : vehicles) {
            boolean isTimeIntersecting = false;
            for (TimeSlot timeSlot : vehicle.getNotAvailabilities()) {
                if (isTimeSlotIntersecting(timeSlotToUnavailable, timeSlot)) {
                    isTimeIntersecting = true;
                    break;
                }
            }
            if (!isTimeIntersecting)
                listOfAvailableVehicles.add(vehicle);
        }
        return listOfAvailableVehicles;
    }

    private boolean isTimeSlotIntersecting(TimeSlot timeSlotToUnavailable, TimeSlot timeSlot) {
        return (timeSlot.getStartTime() <= timeSlotToUnavailable.getStartTime() && timeSlot.getEndTime() > timeSlotToUnavailable.getStartTime())
                ||
                (timeSlotToUnavailable.getStartTime() <= timeSlot.getStartTime() && timeSlotToUnavailable.getEndTime() > timeSlot.getStartTime()) ;
    }


    List<Vehicle> getAllAvailableVehiclesForTimeSlot(TimeSlot timeSlotToUnavailable) {
        return getAllAvailableVehiclesForTimeSlot(timeSlotToUnavailable, this.vehicles);
    }

    public String getBranchName() {
        return branchName;
    }
}
