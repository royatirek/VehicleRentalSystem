package org.example.inputcommandManagement.adapters;

import lombok.AllArgsConstructor;
import org.example.fleetManagement.usecaseLayer.DisplayVehicle;
import org.example.fleetManagement.usecaseLayer.dtos.DisplayVehicleInputDto;
import org.example.inputcommandManagement.executers.DisplayVehicleCommandExecuter;

import java.util.List;


@AllArgsConstructor
public class DisplayVehicleAdapter implements DisplayVehicleCommandExecuter {

    private DisplayVehicle displayVehicle;

    @Override
    public List<String> displayDisplay(String branchName, Integer startTime, Integer endTime) {
        DisplayVehicleInputDto displayVehicleInputDto = new DisplayVehicleInputDto(branchName, startTime, endTime);
        return displayVehicle.displayVehicle(displayVehicleInputDto).getVehicleIds();
    }
}
