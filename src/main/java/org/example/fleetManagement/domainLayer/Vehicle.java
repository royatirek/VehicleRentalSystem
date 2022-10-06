package org.example.fleetManagement.domainLayer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Vehicle {
    private final String id;
    private final Price price;

    private final VehicleType vehicleType;

    private TreeSet<NotAvailabilityTimeSlot> notAvailabilities;


    public Vehicle(String id, Price price, VehicleType vehicleType) {
        this.id = id;
        this.price = price;
        this.vehicleType = vehicleType;
        this.notAvailabilities = new TreeSet<>(Comparator.comparingInt(TimeSlot::getStartTime));
    }

    void makeItUnAvailable(NotAvailabilityTimeSlot notAvailabilityTimeSlots) {
        notAvailabilities.add(notAvailabilityTimeSlots);
    }

    public String getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    List<NotAvailabilityTimeSlot> getNotAvailabilities() {
        return notAvailabilities.stream().collect(Collectors.toList());
    }

}
