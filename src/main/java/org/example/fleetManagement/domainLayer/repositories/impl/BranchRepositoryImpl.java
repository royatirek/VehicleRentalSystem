package org.example.fleetManagement.domainLayer.repositories.impl;

import org.example.fleetManagement.domainLayer.Branch;
import org.example.fleetManagement.domainLayer.exceptions.NoBranchFoundException;
import org.example.fleetManagement.domainLayer.repositories.BranchRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BranchRepositoryImpl implements BranchRepository {
   private List<Branch> branches = new LinkedList<>();

    @Override
    public boolean addBranch(Branch branch) {
       return branches.add(branch);
    }

    @Override
    public Branch getBranchByName(String branchName) {
        Optional<Branch> branch = branches.stream()
                .filter(b -> branchName.equals(b.getBranchName()))
                .findFirst();
        if(branch.isPresent())
            return branch.get();
        throw new NoBranchFoundException(String.format("No branch exists with name %s", branchName));
    }


}
