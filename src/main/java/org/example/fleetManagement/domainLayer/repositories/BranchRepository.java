package org.example.fleetManagement.domainLayer.repositories;

import org.example.fleetManagement.domainLayer.Branch;

public interface BranchRepository {
    boolean addBranch(Branch branch);

    Branch getBranchById(String id);

}
