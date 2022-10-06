package org.example.inputcommandManagement.executers;

import java.util.List;

public interface AddBranchCommandExecuter {
    boolean addBranch(String branchName, List<String> vehicleTypes);
}
