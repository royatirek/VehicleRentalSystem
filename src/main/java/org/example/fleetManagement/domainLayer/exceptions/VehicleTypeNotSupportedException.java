package org.example.fleetManagement.domainLayer.exceptions;

public class VehicleTypeNotSupportedException extends RuntimeException {
    public VehicleTypeNotSupportedException(String message) {
        super(message);
    }
}
