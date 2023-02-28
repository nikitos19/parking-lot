package com.training.parking;

import com.training.parking.spot.Spot;
import com.training.parking.spot.SpotType;
import com.training.parking.vehicle.Vehicle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParkingLot {
    private final Queue<Spot> availableSpots;
    private final Map<Vehicle, Spot> takenSpots = new HashMap<>();

    public ParkingLot(int smallSpotsNumber, int compactSpotsNumber, int largeSpotsNumber) {
        availableSpots = new PriorityQueue<>(smallSpotsNumber + compactSpotsNumber + largeSpotsNumber,
            Comparator.comparing(Spot::getSpotType));
        for (int i = 0; i < smallSpotsNumber; i++) {
            availableSpots.add(new Spot(SpotType.SMALL));
        }
        for (int i = 0; i < compactSpotsNumber; i++) {
            availableSpots.add(new Spot(SpotType.COMPACT));
        }
        for (int i = 0; i < largeSpotsNumber; i++) {
            availableSpots.add(new Spot(SpotType.LARGE));
        }
    }

    public boolean park(Vehicle vehicle) {
        if (availableSpots.isEmpty()) {
            return false;
        }
        Spot availableSpot = availableSpots.stream()
            .filter(spot -> spot.canFitVehicle(vehicle))
            .findFirst()
            .orElse(null);
        if (availableSpot == null) {
            return false;
        }
        availableSpot.occupy(vehicle);
        availableSpots.remove(availableSpot);
        takenSpots.put(vehicle, availableSpot);
        return true;
    }

    public void unpark(Vehicle vehicle) {
        Spot spot = takenSpots.get(vehicle);
        spot.freeUp();
        availableSpots.add(spot);
    }

    @Override
    public String toString() {
        return "ParkingLot{\n" +
            "availableSpots=" + availableSpots +
            "\ntakenSpots=" + takenSpots +
            "\n}";
    }
}
