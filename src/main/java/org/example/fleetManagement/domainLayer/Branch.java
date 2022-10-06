package org.example.fleetManagement.domainLayer;

import java.util.Collections;
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


    List<Vehicle> getVehiclesForVehicleTypeAndTimeSlot(TimeSlot timeSlotToUnavailable, VehicleType vehicleType) {
        List<Vehicle> vehiclesForRequiredType = vehicles.stream()
                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
        return getVehiclesForTimeSlot(timeSlotToUnavailable, vehiclesForRequiredType);
    }

    private List<Vehicle> getVehiclesForTimeSlot(TimeSlot timeSlotToUnavailable, List<Vehicle> vehicles) {
        List<Vehicle> listOfAvailableVehicles = vehicles.stream()
                .filter(vehicle -> !isTimeSlotIntersecting(vehicle.getNotAvailabilities(), timeSlotToUnavailable))
                .collect(Collectors.toList());
        return listOfAvailableVehicles;
    }

    private boolean isTimeSlotIntersecting(List<NotAvailabilityTimeSlot> timeSlots , TimeSlot timeSlotToUnavailable) {
        boolean isTimeSlotIntersecting = false;
        for(TimeSlot timeSlot : timeSlots) {
            if (isTimeSlotIntersecting(timeSlot, timeSlotToUnavailable)) {
                isTimeSlotIntersecting = true;
                break;
            }
        }
        return isTimeSlotIntersecting;
    }

    private boolean isTimeSlotIntersecting(TimeSlot timeSlot, TimeSlot timeSlotToUnavailable) {
        return (timeSlot.getStartTime() <= timeSlotToUnavailable.getStartTime() && timeSlot.getEndTime() > timeSlotToUnavailable.getStartTime())
                ||
                (timeSlotToUnavailable.getStartTime() <= timeSlot.getStartTime() && timeSlotToUnavailable.getEndTime() > timeSlot.getStartTime()) ;
    }


    List<Vehicle> getVehiclesForTimeSlot(TimeSlot timeSlotToUnavailable) {
        return getVehiclesForTimeSlot(timeSlotToUnavailable, this.vehicles);
    }

    public String getBranchName() {
        return branchName;
    }
}
