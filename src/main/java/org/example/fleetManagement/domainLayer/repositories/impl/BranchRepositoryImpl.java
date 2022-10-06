package org.example.fleetManagement.domainLayer.repositories.impl;

import org.example.fleetManagement.domainLayer.Branch;
import org.example.fleetManagement.domainLayer.repositories.BranchRepository;

import java.util.LinkedList;
import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {
   private List<Branch> branches = new LinkedList<>();

    @Override
    public boolean addBranch(Branch branch) {
       return branches.add(branch);
    }

    @Override
    public Branch getBranchById(String branchId) {
        for(Branch branch : branches) {
            if(branch.getBranchName().equals(branchId))
                return branch;
        }
        return null;
    }


}
