package org.example.inputcommandManagement.commands;

public abstract class Command {
     protected String[] commandArguments;

    public abstract void execute();

    public void setCommandArguments(String[] commandArguments) {
        this.commandArguments = commandArguments;
    }
}
