package org.example.inputcommandManagement.commands.impl;

import lombok.AllArgsConstructor;
import org.example.inputcommandManagement.commands.Command;
import org.example.inputcommandManagement.executers.AddBranchCommandExecuter;

@AllArgsConstructor
public class AddBranchCommand extends Command {
    private AddBranchCommandExecuter addBranchCommandExecuter;


    public void execute() {
        System.out.println(addBranchCommandExecuter.addBranch(commandArguments));
    }


}
