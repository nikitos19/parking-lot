package com.training.parking.branch2;

import com.training.parking.branch2.spot.CompactSpot;
import com.training.parking.branch2.spot.LargeSpot;
import com.training.parking.branch2.spot.SmallSpot;
import com.training.parking.branch2.spot.Spot;
import com.training.parking.branch2.vehicle.Vehicle;
import com.training.parking.branch2.vehicle.VehicleType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * The parking lot with Map of vehicle types to available spots
 * <p>
 * It's more difficult to add new vehicle types, because we should have shared spots between different vehicles that fit in that spot.
 * The time complexity should be O(k) where k - vehicle types number
 */
public class ParkingLot_VehicleTypeToSpots {
    private final Map<VehicleType, Queue<Spot>> vehicleTypeToSpots;
    private final Map<Vehicle, Pair<VehicleType, Spot>> takenSpots;

    public ParkingLot_VehicleTypeToSpots(int smallSpotsNumber, int compactSpotsNumber, int largeSpotsNumber) {
        vehicleTypeToSpots = new HashMap<>();
        takenSpots = new HashMap<>();
        vehicleTypeToSpots.put(VehicleType.MOTORCYCLE, new LinkedList<>());
        vehicleTypeToSpots.put(VehicleType.CAR, new LinkedList<>());
        vehicleTypeToSpots.put(VehicleType.TRUCK, new LinkedList<>());

        for (int i = 0; i < smallSpotsNumber; i++) {
            vehicleTypeToSpots.get(VehicleType.MOTORCYCLE).add(new SmallSpot());
        }
        for (int i = 0; i < compactSpotsNumber; i++) {
            vehicleTypeToSpots.get(VehicleType.CAR).add(new CompactSpot());
        }
        for (int i = 0; i < largeSpotsNumber; i++) {
            vehicleTypeToSpots.get(VehicleType.TRUCK).add(new LargeSpot());
        }
    }

    public boolean park(Vehicle vehicle) {
        Queue<Spot> vehicleTypeSpots = vehicleTypeToSpots.get(vehicle.getVehicleType());
        if (!vehicleTypeSpots.isEmpty()) {
            return park(vehicle, vehicle.getVehicleType(), vehicleTypeSpots);
        }
        for (Map.Entry<VehicleType, Queue<Spot>> vehicleTypeToAvailableSlots : vehicleTypeToSpots.entrySet()) {
            if (vehicleTypeToAvailableSlots.getKey().ordinal() < vehicle.getVehicleType().ordinal()
            || vehicleTypeToAvailableSlots.getValue().isEmpty()) {
                continue;
            }
            return park(vehicle, vehicleTypeToAvailableSlots.getKey(), vehicleTypeToAvailableSlots.getValue());
        }
        return false;
    }

    private boolean park(Vehicle vehicle, VehicleType vehicleType, Queue<Spot> availableSpots) {
        Spot availableSpot = availableSpots.poll();
        availableSpot.occupy(vehicle);
        takenSpots.put(vehicle, new Pair<>(vehicleType, availableSpot));
        return true;
    }

    public boolean unpark(Vehicle vehicle) {
        Pair<VehicleType, Spot> vehicleTypeToSpot = takenSpots.get(vehicle);
        if (vehicleTypeToSpot == null) {
            return false;
        }
        Spot spot = vehicleTypeToSpot.second();
        spot.freeUp();
        vehicleTypeToSpots.get(vehicleTypeToSpot.first()).add(spot);
        return true;
    }

    @Override
    public String toString() {
        return "ParkingLot{\n" +
            "vehicle type to available spots: " + vehicleTypeToSpots +
            "\ntakenSpots=" + takenSpots +
            "\n}";
    }

    private record Pair<F, S>(F first, S second) {

        @Override
        public String toString() {
            return second + " for a vehicle type = " + first;
        }
    }
}
