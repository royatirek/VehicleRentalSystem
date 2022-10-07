package org.example;

import org.example.inputcommandManagement.InputCommandFactory;
import org.example.inputcommandManagement.commands.Command;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final File file = new File(args[0]);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            processFile(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static void processFile(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        while (input != null) {
            String[] commandArguments = input.trim().split(" ");
            Command command = InputCommandFactory.getCommand(commandArguments[0].trim());
            command.setCommandArguments(commandArguments);
            command.execute();
            input = reader.readLine();
        }
    }
}

