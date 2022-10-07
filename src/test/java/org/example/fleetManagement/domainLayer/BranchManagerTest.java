package org.example.fleetManagement.domainLayer;

import org.example.fleetManagement.domainLayer.exceptions.NoVehicleFoundException;
import org.example.fleetManagement.domainLayer.exceptions.VehicleTypeNotSupportedException;
import org.example.fleetManagement.domainLayer.repositories.BranchRepository;
import org.example.fleetManagement.domainLayer.strategies.VehicleOrderingStrategy;
import org.example.fleetManagement.domainLayer.strategies.VehicleSelectionStrategy;
import org.example.fleetManagement.domainLayer.strategies.impl.VehicleLowestPriceSelectionStrategy;
import org.example.fleetManagement.domainLayer.strategies.impl.VehicleOrderingByPriceStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


class BranchManagerTest {

    private BranchRepository branchRepository = mock(BranchRepository.class);
    private VehicleOrderingStrategy vehicleOrderingStrategy = mock(VehicleOrderingByPriceStrategy.class);
    private VehicleSelectionStrategy vehicleSelectionStrategy = mock(VehicleLowestPriceSelectionStrategy.class);

    private BranchManager branchManager = new BranchManagerImpl(branchRepository,
            vehicleOrderingStrategy,
            vehicleSelectionStrategy);


    @Test
    void givenNoBranch_whenVehicleIsAdded_thenThrowException() {
        Branch branch = new Branch("B1", new LinkedList<>(), Arrays.asList(VehicleType.CAR));
        Throwable throwable  = assertThrows(VehicleTypeNotSupportedException.class, () ->
                branchManager.addVehicle(branch, new Vehicle("V1", new Price(100), VehicleType.BIKE))
        );
        assertEquals(VehicleTypeNotSupportedException.class, throwable.getClass());
    }

    @Test
    void givenBranchDetails_whenBranchAdded_thenItShouldPersist() {
        Branch branch = new Branch("B1", new LinkedList<>(), Arrays.asList(VehicleType.CAR));
        ArgumentCaptor<Branch> branchCapturer = ArgumentCaptor.forClass(Branch.class);
        branchManager.addBranch(branch);
        verify(branchRepository, atLeast(1)).addBranch(branchCapturer.capture());
        assertEquals(branch.getBranchName(), branchCapturer.getValue().getBranchName());
    }

    @Test
    void givenBranchExists_whenVehicleAddedInBranch_thenItShouldPersist() {
        Branch branch = new Branch("B1", new LinkedList<>(), Arrays.asList(VehicleType.CAR));
        branchManager.addVehicle(branch, new Vehicle("V1", new Price(100), VehicleType.CAR));
        assertEquals("V1", branchManager.getVehicle(branch, "V1").getId());
    }

    @Test
    void givenBranchExistsWithNoVehicle_whenQueried_thenThrowException() {
        Branch branch = new Branch("B1", new LinkedList<>(), Arrays.asList(VehicleType.CAR));
        Throwable throwable = assertThrows(NoVehicleFoundException.class, () ->
                branchManager.getVehicle(branch, "V1"));
        assertEquals(NoVehicleFoundException.class, throwable.getClass());

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void givenBranchExistsWithOneVehicleWithNoBooking_whenAvailableVehicleQueried_thenItShouldReturnOneVehicle(Integer endTime) {
        Branch branch = new Branch("B1", new LinkedList<>(), Arrays.asList(VehicleType.CAR));
        branchManager.addVehicle(branch, new Vehicle("V1", new Price(100), VehicleType.CAR));
        ArgumentCaptor<List<Vehicle>> vehiclesCapturer = ArgumentCaptor.forClass((Class) List.class);


        branchManager.getVehicles(branch, new TimeSlot(1, endTime));

        verify(vehicleOrderingStrategy, times(1)).order(vehiclesCapturer.capture());
        assertEquals(1, vehiclesCapturer.getValue().size());
        assertEquals("V1", vehiclesCapturer.getValue().get(0).getId());
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void givenBranchExistsWithOneVehicleWithOverLappingBooking_whenAvailableVehicleQueried_thenItShouldReturnZeroVehicle(Integer endTime) {
        Branch branch = new Branch("B1", new LinkedList<>(), Arrays.asList(VehicleType.CAR));
        Vehicle vehicle = new Vehicle("V1", new Price(100), VehicleType.CAR);
        branchManager.addVehicle(branch, vehicle);
        branchManager.blockTimeSlot(branch, vehicle, new TimeSlot(1, endTime));

        ArgumentCaptor<List<Vehicle>> vehiclesCapturer = ArgumentCaptor.forClass((Class) List.class);

        branchManager.getVehicles(branch, new TimeSlot(1, 2));

        verify(vehicleOrderingStrategy, times(1)).order(vehiclesCapturer.capture());
        assertEquals(0, vehiclesCapturer.getValue().size());
    }

    @Test
    void givenBranchWithOneCarAndNoBookings_whenVanIsQueried_thenReturnNothing() {
        Branch branch = new Branch("B1", Arrays.asList(new Vehicle("V1", new Price(100), VehicleType.CAR)), Arrays.asList(VehicleType.CAR));
        branchManager.getVehicle(branch, VehicleType.VAN, new TimeSlot(1,2));
        ArgumentCaptor<List<Vehicle>> vehiclesCapturer = ArgumentCaptor.forClass((Class) List.class);
        verify(vehicleSelectionStrategy, times(1)).getSelectedVehicle(vehiclesCapturer.capture());
        assertEquals(0, vehiclesCapturer.getValue().size());

    }

    @Test
    void givenBranchWithTwoCarAndNoBookings_whenCarIsQueried_then2VehiclesIsReturned() {
        List<Vehicle> vehicles = Arrays.asList(new Vehicle("V1", new Price(100), VehicleType.CAR), new Vehicle("V2", new Price(100), VehicleType.CAR));
        Branch branch = new Branch("B1", vehicles, Arrays.asList(VehicleType.CAR));
        branchManager.getVehicle(branch, VehicleType.CAR, new TimeSlot(1,2));
        ArgumentCaptor<List<Vehicle>> vehiclesCapturer = ArgumentCaptor.forClass((Class) List.class);
        verify(vehicleSelectionStrategy, times(1)).getSelectedVehicle(vehiclesCapturer.capture());
        List<String> vehiclesReturned = vehiclesCapturer.getValue().stream().map(Vehicle::getId).collect(Collectors.toList());
        assertEquals(Arrays.asList("V1","V2"), vehiclesReturned);

    }

}