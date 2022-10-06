package org.example.inputcommandManagement;

import org.example.bookingSystem.domainLayer.BookingManager;
import org.example.bookingSystem.domainLayer.BookingManagerImpl;
import org.example.bookingSystem.domainLayer.BookingRepositoryImpl;
import org.example.bookingSystem.usecaseLayer.impl.BookVehicleImpl;
import org.example.fleetManagement.domainLayer.BranchManager;
import org.example.fleetManagement.domainLayer.BranchManagerImpl;
import org.example.fleetManagement.domainLayer.repositories.impl.BranchRepositoryImpl;
import org.example.fleetManagement.domainLayer.strategies.impl.VehicleLowestPriceSelectionStrategy;
import org.example.fleetManagement.domainLayer.strategies.impl.VehicleOrderingByPriceStrategy;
import org.example.fleetManagement.usecaseLayer.impl.AddBranchImpl;
import org.example.fleetManagement.usecaseLayer.impl.AddVehicleImpl;
import org.example.fleetManagement.usecaseLayer.impl.DisplayVehicleImpl;
import org.example.fleetManagement.usecaseLayer.impl.GetAvailableVehicleByTypeImpl;
import org.example.inputcommandManagement.adapters.AddBranchAdapter;
import org.example.inputcommandManagement.adapters.AddVehicleAdapter;
import org.example.inputcommandManagement.adapters.BookVehicleAdapter;
import org.example.inputcommandManagement.adapters.DisplayVehicleAdapter;
import org.example.inputcommandManagement.commands.Command;
import org.example.inputcommandManagement.commands.impl.AddBranchCommand;
import org.example.inputcommandManagement.commands.impl.AddVehicleCommand;
import org.example.inputcommandManagement.commands.impl.BookVehicleCommand;
import org.example.inputcommandManagement.commands.impl.DisplayVehicleCommand;

import java.util.HashMap;
import java.util.Map;

public class InputCommandFactory {
    private static Map<String, Command> mapOfStringAndCommands = new HashMap<>();
    static  {
        BranchManager branchManager = new BranchManagerImpl(
                new BranchRepositoryImpl(),
                new VehicleOrderingByPriceStrategy(),
                new VehicleLowestPriceSelectionStrategy());

        mapOfStringAndCommands.put("ADD_BRANCH", new AddBranchCommand(
                new AddBranchAdapter(new AddBranchImpl(branchManager))));

        mapOfStringAndCommands.put("ADD_VEHICLE", new AddVehicleCommand(
                new AddVehicleAdapter(new AddVehicleImpl(branchManager))));

        mapOfStringAndCommands.put("DISPLAY_VEHICLES", new DisplayVehicleCommand(
                new DisplayVehicleAdapter(new DisplayVehicleImpl(branchManager))));


        BookingManager bookingManager = new BookingManagerImpl(
                new GetAvailableVehicleByTypeImpl(branchManager),
                new BookingRepositoryImpl());

        mapOfStringAndCommands.put("BOOK", new BookVehicleCommand(
                new BookVehicleAdapter(new BookVehicleImpl(bookingManager))));
    }

    public static Command getCommand(String commandType) {
        return mapOfStringAndCommands.get(commandType);
    }
}
