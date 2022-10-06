package org.example;

import org.example.inputcommandManagement.InputCommandFactory;
import org.example.inputcommandManagement.commands.Command;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        while(true) {
//            String[] commandArguments = sc.nextLine().trim().split(" ");
//            if(commandArguments.length == 0)
//                continue;
//            if(commandArguments[0].equals("END"))
//                break;
//            Command command = InputCommandFactory.getCommand(commandArguments[0].trim());
//            command.setCommandArguments(commandArguments);
//            command.execute();

        String filePath = args[0];
        final File file = new File(filePath);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            String[] commandArguments = input.trim().split(" ");
            Command command = InputCommandFactory.getCommand(commandArguments[0].trim());
            command.setCommandArguments(commandArguments);
            input = reader.readLine();
        }
    }
}

