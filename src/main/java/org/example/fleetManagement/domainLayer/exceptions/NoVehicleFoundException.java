package org.example.fleetManagement.domainLayer.exceptions;

public class NoVehicleFound extends RuntimeException {
    public NoVehicleFound(String message) {
        super(message);
    }
}
