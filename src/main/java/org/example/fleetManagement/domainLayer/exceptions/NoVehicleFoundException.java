package org.example.fleetManagement.domainLayer.exceptions;

public class NoVehicleFoundException extends RuntimeException {
    public NoVehicleFoundException(String message) {
        super(message);
    }
}
