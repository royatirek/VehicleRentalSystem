package org.example.inputcommandManagement.adapters;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.usecaseLayer.AddVehicle;
import org.example.fleetManagement.usecaseLayer.dtos.AddVehicleInputDto;
import org.example.inputcommandManagement.executers.AddVehicleCommandExecuter;

@AllArgsConstructor
public class AddVehicleAdapter implements AddVehicleCommandExecuter {
    private AddVehicle addVehicle;
    @Override
    public boolean addVehicle(String[] commandArguments) {
        String branchName = commandArguments[1];
        String vehicleType = commandArguments[2];
        String vehicleId = commandArguments[3];
        Integer price = Integer.parseInt(commandArguments[4]);
        AddVehicleInputDto addVehicleInputDto = new AddVehicleInputDto(branchName, vehicleType, vehicleId, price);
        return addVehicle.addVehicle(addVehicleInputDto).getIsSuccess();
    }
}
