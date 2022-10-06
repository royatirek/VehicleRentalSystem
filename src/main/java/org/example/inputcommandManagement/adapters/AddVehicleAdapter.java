package org.example.inputcommandManagement.adapters;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.usecaseLayer.AddVehicle;
import org.example.fleetManagement.usecaseLayer.dtos.AddVehicleInputDto;
import org.example.inputcommandManagement.executers.AddVehicleCommandExecuter;

@AllArgsConstructor
public class AddVehicleAdapter implements AddVehicleCommandExecuter {
    private AddVehicle addVehicle;
    @Override
    public boolean addVehicle(String branchName, String vehicleType, String vehicleId, Integer price) {
        AddVehicleInputDto addVehicleInputDto = new AddVehicleInputDto(branchName, vehicleType, vehicleId, price);
        return addVehicle.addVehicle(addVehicleInputDto).getIsSuccess();
    }
}
