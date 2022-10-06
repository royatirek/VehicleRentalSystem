package org.example;

import org.example.inputcommandManagement.InputCommandFactory;
import org.example.inputcommandManagement.commands.Command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String[] commandArguments = sc.nextLine().trim().split(" ");
            if(commandArguments.length == 0)
                continue;
            if(commandArguments[0].equals("END"))
                break;
            Command command = InputCommandFactory.getCommand(commandArguments[0].trim());
            command.setCommandArguments(commandArguments);
            command.execute();
        }
    }
}