package org.example.fleetManagement.domainLayer.exceptions;

public class NoBranchFoundException extends RuntimeException {
    public NoBranchFoundException(String message) {
        super(message);
    }
}
