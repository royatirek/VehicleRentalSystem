package org.example.fleetManagement.domainLayer;

public class VehicleTypeNotSupportedException extends RuntimeException {
    public VehicleTypeNotSupportedException(String message) {
        super(message);
    }
}
